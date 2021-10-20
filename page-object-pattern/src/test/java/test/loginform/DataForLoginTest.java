package test.loginform;

public class DataForLoginTest {
    private String textForArticle = "{{В инкубаторе}}\n" +
            "'''Автоматизированное тестирование ПО''' — это процесс тестирования на этапе контроля качества в процессе разработки программного обеспечения. Оно использует программные средства для выполнения тестов и проверки результатов выполнения, что помогает сократить время тестирования и упростить его процесс.\n" +
            "== Инструментарий ==\n" +
            "* [[JUnit]] — тестирование приложений для [[Java]]\n" +
            "* TestNG — тестирование приложений для [[Java]]\n" +
            "* [[NUnit]] — порт JUnit под [[.NET Framework|.NET]]\n" +
            "* [[Selenium]] — тестирование приложений [[HTML]]; поддерживает браузеры [[Internet Explorer]], [[Mozilla Firefox]], [[Opera]], [[Google Chrome]], [[Safari]].\n" +
            "* [[TOSCA Testsuite]] — тестирование приложений [[HTML]], [[.NET Framework|.NET]], [[Java]], [[SAP]]\n" +
            "* [[UniTESK]] — тестирование приложений на [[Java]], [[Си (язык программирования)|Си]].\n" +
            "== Ссылки ==\n" +
            "* [http://automated-testing.info Портал об автоматизации тестирования ПО]\n" +
            "[[Категория:Тестирование программного обеспечения]]";
    private String expectedHeader = "Создание страницы «Инкубатор:Автоматизированное тестирование ПО» — Википедия";

    public String getTextForArticle(){
        return textForArticle;
    }

    public String getExpectedHeader(){
        return expectedHeader;
    }

}
