
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;
import static io.restassured.RestAssured.given;


@RunWith(org.junit.runners.Parameterized.class)
public class RestTest {

    @Parameterized.Parameter
    public static String sites;

    @Parameterized.Parameters
    public static Collection<Object> Sites() {
        Object[] object = new Object[]{"https://auto.ria.com/auto_mitsubishi_lancer_21990745.html",
                "https://auto.ria.com/auto_toyota_camry_22101863.html",
                "https://auto.ria.com/auto_bmw_520_21996828.html",
                "https://auto.ria.com/auto_nissan_leaf_22104675.html",
                "https://auto.ria.com/auto_nissan_leaf_22104647.html",
                "https://auto.ria.com/auto_mercedes_benz_e_220_21994701.html",
                "https://auto.ria.com/auto_lexus_nx_200_22083607.html"};
        return Arrays.asList(object);
    }


    @Test
    public void riaSitesReturn200() {
        given().header("User-Agent","JMETER").
                when().get(sites).
                then().statusCode(200).
                contentType("text/html").
                header("Content-Encoding", "gzip");


    }

}

/*==============Задание по JSON path======================
    1 Вывеcти  на экран список стран из JSON.
        $..results[*].name
    2    Найти список стран расположенных в "Caribbean" саб регионе("geographicSubRegionCode").
        $..results[?(@.geographicSubRegionCode.name=='Caribbean')].name
    3    Вывести на экран "id" для страны "Bosnia and Herzegovina".
        $..results[?(@.name=='Bosnia and Herzegovina')].id
    4    Вывести на экран список саб регионов.
        $..results[*].geographicSubRegionCode.name
    5    Вывести на экран имя "name" страны с кодом("codeNumeric") 166.
        $..results[?(@.codeNumeric==166)].name
     6   Вывести на экран общее количество стран ("totalCount").
        $..totalCount
     7   Вывести на экран все имена полей("fields").
        не до конца понял что именно выводить. Вот все поля name "$..fields[*].name"  или вот все поля внутри fields "$..fields"
      8  Вывести на экран имена всех стран у которых codeNumeric >500
        $..results[?(@.codeNumeric>500)].name
    9    Вывести на экран id всех стран у которых codeNumeric > 100 и < 200.
        $..results[?(@.codeNumeric>100 && @.codeNumeric<200)].name*/
