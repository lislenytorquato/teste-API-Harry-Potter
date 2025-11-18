package casosdetestes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.ParameterizedType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BooksApiTest {


    @DisplayName("CT01 Cenário: Ao buscar livros, a quantidade de livros listados deve ser 8 no idioma escolhido")
    @Test
    void deveRetornarOitoLivros(){

        String[] languages = {"en","es","fr","it","pt","uk"};

        RequestSpecification requestSpecification = given();

        for (int i = 0; i<6;i++) {
            Response response = requestSpecification
                    .baseUri("https://potterapi-fedeperin.vercel.app/")
                    .basePath(languages[i] + "/books")
                    .when()
                    .get()
                    .then()
                    .statusCode(200).body("books", Matchers.hasSize(8)).extract().response();
        }
    }

    @DisplayName("CT02 Cenário: Ao buscar livros, a quantidade de livros listados não deve ser 0 no idioma escolhido")
    @Test
    void deveRetornarMaisQueZeroLivros(){

        String[] languages = {"en","es","fr","it","pt","uk"};

        RequestSpecification requestSpecification = given();

        for (int i = 0; i<6;i++) {
            Response response = requestSpecification
                    .baseUri("https://potterapi-fedeperin.vercel.app/")
                    .basePath(languages[i] + "/books")
                    .when()
                    .get()
                    .then()
                    .statusCode(200).body("books", hasSize(greaterThan(0))).extract().response();
        }
    }

    @DisplayName("CT03 Cenário: Ao buscar livros usando index vàlido no idioma escolhido deve retornar o livro com o index escolhido")
    @Test
    void deveRetornarOLivroDoIndexEscolhido(){

        String[] languages = {"en","es","fr","it","pt","uk"};
        String[] titles = {"Harry Potter and the Prisoner of Azkaban","Harry Potter y el prisionero de Azkaban",
                "Harry Potter et le Prisonnier d'Azkaban","Harry Potter e il Prigioniero di Azkaban",
                "Harry Potter e o Prisioneiro de Azkaban","Гаррі Поттер і в'язень Азкабану" };

        RequestSpecification requestSpecification = given();

        for (int i = 0; i<6;i++) {
                Response response = requestSpecification
                        .baseUri("https://potterapi-fedeperin.vercel.app/")
                        .basePath(languages[i] + "/books")
                        .queryParam("index", 2)
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .body("title", is(titles[i]))
                        .extract().response();
        }
    }

    @DisplayName("CT04 Cenário: Ao buscar livros usando index invàlido no idioma escolhido deve retornar o livro com o index escolhido")
    @Test
    void deveRetornar404PorIndexInvalido(){

        String[] languages = {"en","es","fr","it","pt","uk"};

        RequestSpecification requestSpecification = given();

        for (int i = 0; i<6;i++) {
            Response response = requestSpecification
                    .baseUri("https://potterapi-fedeperin.vercel.app/")
                    .basePath(languages[i] + "/books")
                    .queryParam("index", 8)
                    .when()
                    .get()
                    .then()
                    .statusCode(404)
                    .body("error", is("Invalid Index"))
                    .extract().response();
        }
    }

    @DisplayName("CT05 Cenário: Ao buscar livros usando max válido no idioma escolhido deve retornar os livros com o number até o max escolhido")
    @Test
    void deveRetornarOMaximoDeLivrosEscolhido(){

        String[] languages = {"en","es","fr","it","pt","uk"};

        RequestSpecification requestSpecification = given();

        for (int i = 0; i<6;i++) {
            Response response = requestSpecification
                    .baseUri("https://potterapi-fedeperin.vercel.app/")
                    .basePath(languages[i] + "/books")
                    .queryParam("max", 3)
                    .when()
                    .get()
                    .then()
                    .statusCode(200)
                    .body("number", contains(1,2,3))
                    .extract().response();
        }
    }

    @DisplayName("CT06 Cenário: Ao buscar livros usando max e page válidos no idioma escolhido deve retornar os livros do grupo indicado")
    @Test
    void deveRetornarOConjuntoMaximoDeLivrosEscolhidoComMaxEPageValidos(){

        String[] languages = {"en","es","fr","it","pt","uk"};

        RequestSpecification requestSpecification = given();

        for (int i = 0; i<6;i++) {
            Response response = requestSpecification
                    .baseUri("https://potterapi-fedeperin.vercel.app/")
                    .basePath(languages[i] + "/books")
                    .queryParam("max", 2)
                    .queryParam("page",2)
                    .when()
                    .get()
                    .then()
                    .statusCode(200)
                    .body("number", contains(3,4))
                    .extract().response();
        }
    }

    @DisplayName("CT07 Cenário: Ao buscar livros usando max e page inválidos no idioma escolhido deve retornar mensagem de erro")
    @Test
    void deveRetornar404ComMaxEPageInvalidos(){

        String[] languages = {"en","es","fr","it","pt","uk"};

        RequestSpecification requestSpecification = given();

        for (int i = 0; i<6;i++) {
            Response response = requestSpecification
                    .baseUri("https://potterapi-fedeperin.vercel.app/")
                    .basePath(languages[i] + "/books")
                    .queryParam("max", 2)
                    .queryParam("page",6)
                    .when()
                    .get()
                    .then()
                    .statusCode(404)
                    .body("error", is("Invalid Params"))
                    .extract().response();
        }
    }


}
