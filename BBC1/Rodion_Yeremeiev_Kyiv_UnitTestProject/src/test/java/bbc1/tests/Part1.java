package bbc1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class
Part1 extends BaseTest {

    private static final String ARTICLE_TEXT_EXPECTED = "Death toll mounts in raging South Africa riots";
    private static final String SEARCH_BY_CATEGORY_EXPECTED_ARTICLE_TITLE = "Africa Eye: Africa Eye: Retirement Hell";

    private final List<String> expectedTitles = Arrays.asList
            (
                    "'Pushing back' asylum seekers at sea",
                    "The epidemic within the pandemic",
                    "'I’ve wanted to bleach the brown out of me'",
                    "Bank scammer threatens BBC reporter",
                    "Taking on the king in Eswatini"
            );

    //TODO: #1 Add a test that:
    // Goes to BBC
    // Clicks on News
    // Checks the name of the headline article
    // (the one with the biggest picture and text)
    // against a value specified in your test (hard-coded)
    @Test
    public void testOne() {
        getNewsPage().waitForVisibilityOfElement(30, getNewsPage().getHeadLineArticle());
        Assert.assertTrue(getNewsPage().getHeadLineArticleText().contains(ARTICLE_TEXT_EXPECTED));
    }

    //TODO: #2 Add a test that:
    // Goes to BBC
    // Clicks on News
    // Checks secondary article titles (the ones to the right and below the headline article)
    // against a List specified in your test (hard-coded).
    // Imagine that you are testing the BBC site on a test environment, and you know what the titles will be.
    // Your test, then, checks that these titles are in fact present on the page.
    // The test should pass if all the titles are found, and fail if they are not found.
    // It's normal that your test will fail the next day -
    // this would not happen if we had a Test environment for BBC, with a static database.
    @Test
    public void testTwo() {
        List<String> listOfTitlesActual = getNewsPage().getMostWatchedArticlesList().stream().map(s -> s.getText()).collect(Collectors.toList());
        listOfTitlesActual.stream().forEach(System.out::println);
        Assert.assertEquals(listOfTitlesActual, expectedTitles);
    }


    //TODO: #3 Add a test that:
    // Goes to BBC
    // Clicks on News
    // Stores the text of the Category link of the headline article (e.g. World, Europe...)
    // Enter this text in the Search bar
    // Check the name of the first article against a specified value (hard-coded)
    @Test
    public void testThree() {
        getNewsPage().searchByHeadlineCategory();
        getSearchResultPage().waitForAllElementsPresent(30, getSearchResultPage().getArticles());
        Assert.assertEquals(getSearchResultPage().getArticles().get(0).getText(), SEARCH_BY_CATEGORY_EXPECTED_ARTICLE_TITLE);
    }

}
