package com.baeldung;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class GlobalConstants {

    // env properties
    public static String ENV_PROPERTY_BASE_URL = "base.url";
    public static String ENV_PROPERTY_SPRING_PROFILE = "spring.profiles.active";
    public static String ENV_PROPERTY_TARGET_ENV = "target.env";

    public static String DEFAULT_SPRING_PROFILE = "headless-browser";

    // targent env
    public static String TARGET_ENV_WINDOWS = "win";
    public static String TARGET_ENV_LINUX = "linux";

    // headless browser name
    public static String HEADLESS_BROWSER_PHANTOMJS = "phantomJS";
    public static String HEADLESS_BROWSER_HTMLUNIT = "HtmlUnit";

    public static String BAELDUNG_HOME_PAGE_URL = "https://www.baeldung.com";
    public static String BAELDUNG_HOME_PAGE_URL_WITH_HTTP = "http://www.baeldung.com";
    public static String BAELDUNG_HOME_PAGE_URL_WIThOUT_THE_PROTOCOL = "www.baeldung.com";
    public static String BAELDUNG_DOMAIN_NAME = "baeldung.com";
    public static String LAUNCH_FLAG = "LAUNCH_FLAG";
    public static String NUMBER_ONE = "1";
    public static String STRING_WITH_SINGLE_SPACE = " ";

    public static String FULL_ARCHIVE_URL = "https://www.baeldung.com/full_archive";
    public static String PAGES_SITEMAP_URL = "https://www.baeldung.com/page.xml";

    // url files
    public static String ALL_ARTICLES_FILE_NAME = "all-articles.txt";
    public static String SAMPLE_ARTICLES_FILE_NAME = "sample-articles.txt";
    public static String ALL_PAGES_FILE_NAME = "all-pages.txt";
    public static String SAMPLE_PAGES_FILE_NAME = "sample-pages.txt";

    public static String BLOG_URL_LIST_RESOUCE_FOLDER_PATH = "./blog-url-list/";

    public static String BLOG_URL_LIST_RESOUCE_FOLDER_PATH_ENV_VARIABLE = "blog-url-list";

    public static String COURSE_PAGES_BUY_LINKS = "coursePagesBuyLinks.json";

    /**
     * Tests using this tag are executed every 30 minutes on Jenkins
     */
    public static final String TAG__EVERY_30_MINUTES = "every-30-minutes";

    /**
     * Tests using this tag are executed hourly on Jenkins
     */
    public static final String TAG_HOURLY = "hourly";

    /**
     * Tests using this tag are executed daily on Jenkins with PhantomJS
     */
    public static final String TAG_DAILY = "daily";

    /**
     * Tests using this tag are executed daily on Jenkins with HtmlUnit 
     */
    public static final String TAG_DAILY_HTMLUNIT = "daily-htmlunit";

    /**
     * Tests using this tag are executed weekly on Jenkins
     */
    public static final String TAG_WEEKLY = "weekly";

    /**
     * Tests using this tag are executed bi-monthly
     */
    public static final String TAG_BI_MONTHLY = "bi-monthly";

    /**
     * Tests using this tag are executed monthly on Jenkins
     */
    public static final String TAG_MONTHLY = "monthly";

    /**
     * Tests using this tag can be executed using on Demand genkins job.
     */
    public static final String GA_TRACKING = "ga-tracking";

    // pages

    public static final String ARTICLE_WITH_POPUP = "/rest-with-spring-series/";
    public static final String ARTICLE_WITH_SERIES = "/spring-security-registration/";
    public static final String ARTICLE_WITH_PESISTENCE_EBOOK_DOWNLOAD = "/hibernate-spatial/";

    public static final ImmutableList<String> PAGES_WITH_BLANK_TITLE = ImmutableList.of("/java-weekly-sponsorship/", "/webinar-rest-with-spring-thank-you", "/webinar-api-security-thank-you", "/webinar-api-discoverability-thank-you", "/webinar-cqrs-thank-you");

    // for redirection tests
    public static String BAELDUNG_HOME_PAGE_URL_WITHOUT_WWW_PREFIX = "https://baeldung.com";
    public static String BAELDUNG_HOME_PAGE_URL_WITH_WWW_PREFIX = "https://www.baeldung.com";

    public static String BAELDUNG_FEED_URL = "https://www.baeldung.com/feed/";
    public static String BAELDUNG_FEED_FEEDBURNER_URL = "http://feeds.feedburner.com/Baeldung";

    // for Google Analytics

    public static final String ARTICLE_WITH_GOOGLE_ANALYTICS = "/persistence-layer-with-spring-and-hibernate/";
    public static final String PAGE_WITH_GOOGLE_ANALYTICS = "/rest-with-spring-course/";
    public static final String GOOGLE_ANALYTICS_CODE_SEARCH_STRING = "https://www.google-analytics.com/analytics.js";

    // for testing noindex on category/tag

    public static final String CATEGORY_URL = "/category/series/";
    public static final String TAG_ARTICLE_URL = "/tag/activiti/";

    // JW articles
    public static final List<String> ARTILCE_JAVA_WEEKLY = Arrays.asList(new String[] { "java-web-weekly", "java-weekly", "-week-review" });

    // URL should not included in the article list due to 1- article is written for 2- it's a page
    public static final List<String> flaggedArticles = Collections
            .unmodifiableList(Arrays.asList("/2016-week-review-2/", "/java-json/", "/guide-to-jayway-jsonpath/", "/conferences-in-may-2016/", "/content-editor-job/", "/video-creation-job/", "/technical-editor-job/"));

    // drip related
    public static final String DRIP_SUBSCRIPTION_QUERY_STRING = "?__s=pt6zwpj2bqmwzhwxgqnf";
    public static final String DRIP_CUTOM_FIELD = "job_role";
    public static final String DRIP_CUTOM_FIELD_VALUE_ARCHITECT = "job_role=architect";

    // thank-you page
    public static final List<String> PAGES_THANK_YOU = Arrays.asList(new String[] { "thank-you", "thanks" });

    public static final List<String> URLS_EXCLUDED_FROM_META_DESCRIPTION_TEST = Arrays.asList(new String[] { "/start-here/", "/spring-5/", "/swagger-test-on-a-page/", "/follow/", "/baeldung-company-info/", "/contact/", "/rest-course-almost-done/" });

    // Baeldung GitHub repos

    public static final String GITHUB_REPO_EUGENP = "github.com/eugenp";
    public static final String GITHUB_REPO_BAELDUNG = "github.com/baeldung";

    // these URLs should be excluded from givenArticlesWithALinkToTheGitHubModule_whenTheArticleLoads_thenTheGitHubModuleLinksBackToTheArticle test because:
    // 1- these target multiple GitHub repos
    // 2- More than one GitHub modules linked in the article
    // 3- back-link from GitHub not required
    public static final List<String> URL_EXCLUDED_FROM_ARTICELS_GITHUB_LINKS_TEST = Collections
            .unmodifiableList(Arrays.asList("/cookbooks/", "/security-spring/", "/maven-dire/", "/slf4j-with-log4j2-logback/", "/spring-security-expressions-basic/", "/2013/02/25/tweeting-stackexchange-with-spring-social-part-1/",
                    "/2012/01/03/this-is-not-your-fathers-spring-a-learning-project/", "/persistence-with-spring-series/", "/persistence-with-spring-series-alternative/", "/design-a-user-friendly-java-library/"));

    // for Q2W3 Fixed Widget test

    public static final String ARTICLE_FOR_FIXED_WIDGET_TEST = "/java-classloaders/";
    public static final String PAGE_FOR_FIXED_WIDGET_TEST = "/spring-tutorial";

    // for Sticky Sidebar plugin

    public static final String ARTICLE_FOR_STICKY_SIDEBAR_TEST = "/java-classloaders/";
    public static final String PAGE_FOR_STICKY_SIDEBAR_TEST = "/spring-tutorial";

    // for Drip script

    public static final String ARTICLE_WITH_DRIP_SCRIPT = "/spring-cache-tutorial/";
    public static final String PAGE_WITH_DRIP_SCRPT = "/spring-tutorial/";
    public static final String DRIP_SCRPT_SEARCH_STRING = "dc.src = '//tag.getdrip.com/9539554.js';";

    // for crawler4j
    public static String README_LINKS_FOLDER_PATH = "./blog-url-list/";
    public static String README_LINKS_FILE_NAME = "readme-files-urls.txt";
    public static String README_FILE_NAME_LOWERCASE = "readme.md";
    public static final String CRAWLER4J_STORAGE_FOLDER = "crawl/root";

    // VAT test
    public static final String COURSE_PAGE_FOR_VAT_TEST = "/learn-spring-security-course/";
    public static final String COURSE_PAGE_TITLE_FOR_VAT_TEST = "The Learn Spring Security Course | Baeldung";

    public static final String REPO_GITHUB_TUTORIALS_LINK = "https://github.com/eugenp/tutorials";
    public static final String REPO_GITHUB_BAELDUNG_LINK = "https://github.com/baeldung";

    // GeoIP API provider logs
    public static final List<String> GEOIP_API_PROVIDER_SUCCESS_LOGS = Collections.unmodifiableList(Arrays.asList("VAT CALC NOTICE: GEOIP API PROVIDER IS SET TO IPINFO.IO", "VAT CALC NOTICE: GEOIP API PROVIDER IS SET TO IPAPI.COM"));
    
    //ignore list for givenTheGitHubModule_theModuleHasANonEmptyReadme
    public static String IGNORE_EMPTY_README_LIST_KEY = "ignoreEmptyReadmeContaining";
    public static String IGNORE_MISSING_README_LIST_KEY = "ignoreMissingReadmeContaining";

}
