# Forum Application

Forum application with multiple forums, topics, answers, comments, supporting WYSIWYG editor and Votes.

* Project Lead: [Alexandru Cotiugă](http://www.xwiki.org/xwiki/bin/view/XWiki/acotiuga)
* [Documentation & Download](http://extensions.xwiki.org/xwiki/bin/view/Extension/ForumApplication)
* [Issue Tracker](http://jira.xwiki.org/browse/XAFORUM)
* Communication: [Mailing List](http://dev.xwiki.org/xwiki/bin/view/Community/MailingLists>), [IRC]( http://dev.xwiki.org/xwiki/bin/view/Community/IRC)
* [Development Practices](http://dev.xwiki.org)
* Minimal XWiki version supported: XWiki 8.4
* License: LGPL v3
* [Translations](https://l10n.xwiki.org/projects/xwiki-contrib/forum-application/)
* Sonar Dashboard: N/A
* Continuous Integration Status: [![Build Status](http://ci.xwiki.org/job/XWiki%20Contrib/job/application-forum/job/master/badge/icon)](http://ci.xwiki.org/job/XWiki%20Contrib/job/application-forum/job/master/)

# Release

* Release

```
mvn release:prepare -Pintegration-tests
mvn release:perform -Pintegration-tests
```
