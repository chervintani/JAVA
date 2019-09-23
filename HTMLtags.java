package htmltags;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class HTMLTags {

    private static CharSequence txt;

    public static void main(String[] args) {

        ArrayList<String> tags = new ArrayList<String>();
//        Set<String> distinct = new HashSet<>(tags);

        String toSearch = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                + "    <title>The requested URL could not be retrieved</title>\n"
                + "    <link href=\"http://passthrough.fw-notify.net/static/default.css\" rel=\"stylesheet\" type=\"text/css\" />\n"
                + "    <script type=\"text/javascript\" src=\"http://passthrough.fw-notify.net/static/default.js\"></script>\n"
                + "  </head>\n"
                + "  <body onload=\"checkResize();\">\n"
                + "    <div id=\"emsg_large\"></div>\n"
                + "    <div id=\"page\">\n"
                + "      <div id=\"header\">\n"
                + "        <div><img src=\"http://passthrough.fw-notify.net/static/topbar_left.png\" width=\"6\" height=\"72\" border=\"0\" /></div>\n"
                + "        <div id=\"company_logo\"><img src=\"http://passthrough.fw-notify.net/static/logo.png\" border=\"0\" /></div>\n"
                + "        <div id=\"company_text\"><h1 class=\"orange\"></h1></div>\n"
                + "        <div><img src=\"http://passthrough.fw-notify.net/static/topbar_right.png\" width=\"6\" height=\"72\" border=\"0\" /></div>\n"
                + "      </div>\n"
                + "      <br class=\"clearer\" />\n"
                + "\n"
                + "      <div id=\"content\">\n"
                + "        <img src=\"http://passthrough.fw-notify.net/static/warning.png\" border=\"0\" align=\"left\" />\n"
                + "        <h1 class=\"orange\">An error occurred while handling your request</h1>\n"
                + "\n"
                + "        <div class=\"line\">\n"
                + "          <div class=\"label\">While trying to retrieve the URL:</div>\n"
                + "          <div class=\"desc\"> \n"
                + "            <span>http://www.cdu.edu.ph/</span>\n"
                + "          </div>\n"
                + "        </div>\n"
                + "\n"
                + "        <div class=\"line\">\n"
                + "          <div class=\"label\">The content could not be delivered due to the following condition:</div>\n"
                + "          <div class=\"desc\"> \n"
                + "            Connection refused\n"
                + "          </div>\n"
                + "        </div>\n"
                + "\n"
                + "        <div class=\"line\">\n"
                + "          <div class=\"label\"></div>\n"
                + "          <div class=\"desc\"> \n"
                + "            \n"
                + "          </div>\n"
                + "        </div>\n"
                + "        <br class=\"clearer\" />\n"
                + "      </div> <!-- END: div#content -->\n"
                + "      <br class=\"clearer\" />\n"
                + "\n"
                + "      <div id=\"footer\">\n"
                + "        <div><a href=\"http://www.sophos.com\" target=\"_blank\" title=\"Sophos\"><img src=\"http://passthrough.fw-notify.net/static/footer_left.png\" width=\"136\" height=\"33\" border=\"0\" /></a></div>\n"
                + "        <div class=\"orange\" id=\"copyright\">Powered by UTM Web Protection</div>\n"
                + "        <div><img src=\"http://passthrough.fw-notify.net/static/footer_right.png\" width=\"6\" height=\"33\" border=\"0\" /></div>\n"
                + "      </div> <!-- END: div#footer -->\n"
                + "    </div> <!-- END: div#page -->\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        Pattern p = Pattern.compile("<([^\\s>/]+)");
        Matcher m = p.matcher(toSearch);
        while (m.find()) {
            String tag = m.group(1);
            tags.add(tag);
        }
        Set<String> distinct = new HashSet<>(tags);
        for (String s : distinct) {
            System.out.println(s + ": " + Collections.frequency(tags, s));
        }
    }
}
