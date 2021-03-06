package com.baeldung.selenium.common;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.baeldung.GlobalConstants;
import com.baeldung.common.TestUtils;
import com.baeldung.selenium.base.BaseUISeleniumTest;
import com.baeldung.util.Utils;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class AllArticlesUITest extends BaseUISeleniumTest {

    @Value("#{'${site.excluded.authors}'.split(',')}")
    private List<String> excludedListOfAuthors;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private ListIterator<String> allArticlesList;
    Multimap<String, String> badURLs = ArrayListMultimap.create();

    boolean loadNextUrl = true;
    boolean allTestsFlag = false;

    @BeforeEach
    public void loadNewWindow() throws IOException {
        logger.info("inside loadNewWindow()");
        allTestsFlag = false;
        page.openNewWindow();
        allArticlesList = Utils.fetchAllArtilcesAsListIterator();
        badURLs.clear();
        loadNextURL();
    }

    @AfterEach
    public void closeWindow() {
        page.quiet();
    }

    @Test
    @Tag("givenAllTheArticles_whenArticleLoads_thenArticleHasNoEmptyDiv")
    public final void givenAllTheArticles_whenArticleLoads_thenArticleHasNoEmptyDiv() throws IOException {
        do {
            if (page.findEmptyDivs().size() > 0) {
                badURLs.put("givenAllTheArticles_whenArticleLoads_thenArticleHasNoEmptyDiv", page.getUrlWithNewLineFeed());
            }
        } while (loadNextURL());

        if (!allTestsFlag && badURLs.size() > 0) {
            Utils.triggerTestFailure(badURLs.toString());
        }
    }

    @Test
    @Tag("givenAllArticleList_whenArticleLoads_thenItHasSingleShortcodeAtTheTop")
    public final void givenAllArticleList_whenArticleLoads_thenItHasSingleShortcodeAtTheTop() throws IOException {
        do {
            if (!Utils.excludePage(page.getUrl(), GlobalConstants.ARTILCE_JAVA_WEEKLY, false) && page.findShortCodesAtTheTopOfThePage().size() != 1) {
                badURLs.put("givenAllArticleList_whenArticleLoads_thenItHasSingleShortcodeAtTheTop", page.getUrlWithNewLineFeed());
            }
        } while (loadNextURL());

        if (!allTestsFlag && badURLs.size() > 0) {
            Utils.triggerTestFailure(badURLs.toString());
        }
    }

    @Test
    @Tag("givenAllArticleList_whenArticleLoads_thenItHasSingleShortcodeAtTheEnd")
    public final void givenAllArticleList_whenArticleLoads_thenItHasSingleShortcodeAtTheEnd() throws IOException {
        do {
            if (!Utils.excludePage(page.getUrl(), GlobalConstants.ARTILCE_JAVA_WEEKLY, false) && page.findShortCodesAtTheEndOfThePage().size() != 1) {
                badURLs.put("givenAllArticleList_whenArticleLoads_thenItHasSingleShortcodeAtTheEnd", page.getUrlWithNewLineFeed());
            }
        } while (loadNextURL());

        if (!allTestsFlag && badURLs.size() > 0) {
            Utils.triggerTestFailure(badURLs.toString());
        }
    }

    @Test
    @Tag("givenAllTheArticles_whenArticleLoads_thenImagesPointToCorrectEnv")
    @Tag("givenAllTheURLs_whenURLLoads_thenImagesPointToCorrectEnv")
    public final void givenAllTheArticles_whenArticleLoads_thenImagesPointToCorrectEnv() throws IOException {
        do {
            List<WebElement> imgTags = page.findImagesPointingToInvalidEnvOnTheArticle();
            if (imgTags.size() > 0) {
                badURLs.put("givenAllTheArticles_whenArticleLoads_thenImagesPointToCorrectEnv", page.getUrlWithNewLineFeed() + " ( " + imgTags.stream().map(webElement -> webElement.getAttribute("src") + " , ").collect(Collectors.joining()) + ")\n\n");
            }
        } while (loadNextURL());

        if (!allTestsFlag && badURLs.size() > 0) {
            Utils.triggerTestFailure(badURLs.toString());
        }
    }

    @Test
    @Tag("givenAllArticles_whenArticleLoads_thenTheMetaDescriptionExists")
    @Tag("givenAllTheURLs_whenURLLoads_thenTheMetaDescriptionExists")
    public final void givenAllArticles_whenArticleLoads_thenTheMetaDescriptionExists() throws IOException {
        do {
            if (!Utils.excludePage(page.getUrl(), GlobalConstants.URLS_EXCLUDED_FROM_META_DESCRIPTION_TEST, true) && !page.findMetaDescriptionTag()) {
                badURLs.put("givenAllArticles_whenArticleLoads_thenTheMetaDescriptionExists", page.getUrlWithNewLineFeed());
            }
        } while (loadNextURL());

        if (!allTestsFlag && badURLs.size() > 0) {
            Utils.triggerTestFailure(badURLs.toString());
        }
    }

    /**
     * The test looks into four locations for searching a back-link
     * First URL - the URL linked from the article
     * 2nd URL - the immediate parent of the first URL
     * 3rd URL - the master module, immediate child of \master\
     * 4th URL - the immediate child of the parent(eugenp or Baeldung) repository 
     */

    @Test
    @Tag("givenArticlesWithALinkToTheGitHubModule_whenTheArticleLoads_thenTheGitHubModuleLinksBackToTheArticle")
    public final void givenArticlesWithALinkToTheGitHubModule_whenTheArticleLoads_thenTheGitHubModuleLinksBackToTheArticle() throws IOException {
        List<String> gitHubModuleLinks = null;
        do {
            if (!Utils.excludePage(page.getUrl(), GlobalConstants.ARTILCE_JAVA_WEEKLY, false) && !Utils.excludePage(page.getUrl(), GlobalConstants.URL_EXCLUDED_FROM_ARTICELS_GITHUB_LINKS_TEST, true)) {
                gitHubModuleLinks = page.findLinksToTheGithubModule();
                if (!TestUtils.articleLinkFoundOnGitHubModule(gitHubModuleLinks, page.getRelativeUrl(), page)) {
                    badURLs.put("givenArticlesWithALinkToTheGitHubModule_whenTheArticleLoads_thenTheGitHubModuleLinksBackToTheArticle", page.getUrlWithNewLineFeed());
                }
            }

        } while (loadNextURL());

        if (!allTestsFlag && badURLs.size() > 0) {
            Utils.triggerTestFailure(badURLs.toString());
        }
    }

    @Test
    @Tag("givenAllTheArticles_whenAnArticleLoads_thenTheAuthorIsNotFromTheExcludedList")
    public final void givenAllTheArticles_whenAnArticleLoads_thenTheAuthorIsNotFromTheExcludedList() throws IOException {
        do {
            String authorName = page.findAuthorOfTheArticle();
            if (excludedListOfAuthors.contains(authorName.toLowerCase())) {
                badURLs.put("givenAllTheArticles_whenAnArticleLoads_thenTheAuthorIsNotFromTheExcludedList", page.getUrlWithNewLineFeed());
            }
        } while (loadNextURL());

        if (!allTestsFlag && badURLs.size() > 0) {
            Utils.triggerTestFailure(badURLs.toString());
        }
    }

    @Test
    @Tag("givenAllTheArticles_whenAnArticleLoads_thenMetaOGImageAndTwitterImagePointToTheAbsolutePath")
    @Tag("givenAllTheURls_whenAURLLoads_thenMetaOGImageAndTwitterImagePointToTheAbsolutePath")
    public final void givenAllTheArticles_whenAnArticleLoads_thenMetaOGImageAndTwitterImagePointToTheAbsolutePath() throws IOException {
        do {
            if (!page.findMetaTagWithOGImagePointingToTheAbsolutePath() || !page.findMetaTagWithTwitterImagePointingToTheAbsolutePath()) {
                badURLs.put("givenAllTheArticles_whenAnArticleLoads_thenMetaOGImageAndTwitterImagePointToTheAbsolutePath", page.getUrlWithNewLineFeed());
            }
        } while (loadNextURL());

        if (!allTestsFlag && badURLs.size() > 0) {
            Utils.triggerTestFailure(badURLs.toString());
        }
    }

    @Test
    @Tag("givenTestsTargetedToAllArticlesUrls_whenTheTestRuns_thenItPasses")
    @Tag("givenTestsTargetedToAllUrls_whenTheTestRuns_thenItPasses")
    @Tag(GlobalConstants.TAG_BI_MONTHLY)
    public final void givenTestsTargetedToAllArticlesUrls_whenTheTestRuns_thenItPasses() throws IOException {
        allTestsFlag = true;
        do {
            loadNextUrl = false;
            try {
                givenAllTheArticles_whenArticleLoads_thenArticleHasNoEmptyDiv();
                givenAllArticleList_whenArticleLoads_thenItHasSingleShortcodeAtTheTop();
                givenAllArticleList_whenArticleLoads_thenItHasSingleShortcodeAtTheEnd();
                givenAllTheArticles_whenArticleLoads_thenImagesPointToCorrectEnv();
                givenAllArticles_whenArticleLoads_thenTheMetaDescriptionExists();
                givenArticlesWithALinkToTheGitHubModule_whenTheArticleLoads_thenTheGitHubModuleLinksBackToTheArticle();
                givenAllTheArticles_whenAnArticleLoads_thenTheAuthorIsNotFromTheExcludedList();
                givenAllTheArticles_whenAnArticleLoads_thenMetaOGImageAndTwitterImagePointToTheAbsolutePath();
            } catch (Exception e) {
                logger.error("Error occurened while process:" + page.getUrl() + " error message:" + e.getMessage());
            }
            loadNextUrl = true;
        } while (loadNextURL());

        if (badURLs.size() > 0) {
            String testsResult = "\n\n\n";
            for (Map.Entry<String, Collection<String>> entry : badURLs.asMap().entrySet()) {
                testsResult = testsResult + entry.getKey() + "=" + entry.getValue().toString() + "\n\n\n";
            }
            Utils.triggerTestFailure(testsResult);
        }
    }

    private boolean loadNextURL() {
        if (!allArticlesList.hasNext() || !loadNextUrl) {
            return false;
        }

        page.setUrl(page.getBaseURL() + allArticlesList.next());
        logger.info(page.getUrl());

        page.loadUrlWithThrottling();

        return true;

    }

}
