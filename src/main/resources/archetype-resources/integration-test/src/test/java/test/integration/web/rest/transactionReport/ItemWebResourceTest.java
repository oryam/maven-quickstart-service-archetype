#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.test.integration.web.rest.transactionReport;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import ${package}.common.util.test.CommonTest;
import ${package}.web.common.ItemDetailView;
import ${package}.web.common.ItemSearchResultView;
import ${package}.web.config.RestApiUrlConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemWebResourceTest extends CommonTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_response_detail() {

        String url = RestApiUrlConfig.buildUrl(true, RestApiUrlConfig.ITEM_DETAIL);

        Long id = 1L;
        ResponseEntity<ItemDetailView> response = restTemplate.getForEntity(url, ItemDetailView.class, id);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        ItemDetailView result = response.getBody();
        assertThat(result.getCode()).isEqualTo("ITEM_1");
        assertThat(result.getValue().doubleValue()).isEqualTo(1.01);
    }

    @Test
    public void should_response_all_values() {

        String url = RestApiUrlConfig.buildUrl(true, RestApiUrlConfig.ITEM);

        ResponseEntity<ItemSearchResultView> response = restTemplate.getForEntity(url, ItemSearchResultView.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        ItemSearchResultView result = response.getBody();
        assertThat(result.getTotal()).isEqualTo(3);
        assertThat(result.getValues()).hasSize(3);
    }

    @Test
    public void should_request_search_by_criteria() {

        String url = RestApiUrlConfig.buildUrl(true, RestApiUrlConfig.ITEMS);

        String codeStartWith = "ITEM";
        ResponseEntity<ItemSearchResultView> response = restTemplate.postForEntity(url, codeStartWith, ItemSearchResultView.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        ItemSearchResultView result = response.getBody();
        assertThat(result.getTotal()).isEqualTo(2);
        assertThat(result.getValues()).hasSize(2);
        assertThat(result
                         .getValues()
                         .stream()
                         .filter(value -> value.getCode().startsWith(codeStartWith))
                         .count()).isEqualTo(2);
    }
}
