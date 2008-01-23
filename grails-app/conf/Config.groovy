// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

// from controllers:   def propValue = grailsApplication.config.my.property
// from services: ConfigurationHolder.config.my.custom.data
// import org.codehaus.groovy.grails.commons.ConfigurationHolder

grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format

grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text-plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// The default codec used to encode data with ${}
grails.views.'default.codec'="none" // none, html, base64

// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true

thumbnail {
	enabled=true
	serviceurl="http://localhost:7999"
	dir = "/data/thumbs/groovyblogs"
}

pdf {
	dir=System.properties["java.io.tmpdir"]
}

cache {
	enabled = true
}

mail {
	host="latte"
	from="glen@groovyblogs.org"
    subject="Welcome to groovyblogs.org"
	enabled=true
}

http {
	useproxy=true
	host="192.168.1.7"
	port=3128
	useragent="GroovyBlogs/1.0 (http://www.groovyblogs.org)"
	usefeedburner=true
	maxpollsperminute=3
	feedburner_atom="http://feeds.feedburner.com/groovyblogs"
	feedburner_rss="http://feeds.feedburner.com/groovyblogs" 
	feedburner_stats_url="http://feeds.feedburner.com/~fc/groovyblogs?bg=99CCFF&amp;fg=444444&amp;anim=0"
}

lists {
	groovy="http://www.nabble.com/groovy---user-f11867.xml"
	grails="http://www.nabble.com/grails---user-f11861.xml"	
}

translate {
	enabled=true
	url='http://translate.google.com/translate?u=${url}&langpair=${from}|${to}hl=${to}'
	        // http://translate.google.com/translate?u=http%3A%2F%2Fgroovy.org.es%2Fhome%2Fstory%2F12&langpair=es%7Cen&hl=en&ie=UTF-8&oe=UTF-8&prev=%2Flanguage_tools
	langs=[
	                  "german"  : "de",
	                  "french"  : "fr",
	                  "spanish" : "es",
	                  "italian" : "it",
	                  
	                  "japanese"   : "ja",
	                  "korean"     : "ko",
	                  "portuguese" : "pt",
	                  "russian"    : "ru",
	                  "arabic"     : "ar",
	                  "chinese"    : "zh",
	                  
	                  
	        ]	
	
}



// log4j configuration
log4j {
    appender.stdout = "org.apache.log4j.ConsoleAppender"
    appender.'stdout.layout'="org.apache.log4j.PatternLayout"
    appender.'stdout.layout.ConversionPattern'='[%r] %c{2} %m%n'
    appender.errors = "org.apache.log4j.FileAppender"
    appender.'errors.layout'="org.apache.log4j.PatternLayout"
    appender.'errors.layout.ConversionPattern'='[%r] %c{2} %m%n'
    appender.'errors.File'="stacktrace.log"
    rootLogger="error,stdout"
    logger {
        grails="debug"
        StackTrace="error,errors"
        org {
            codehaus.groovy.grails.web.servlet="error"  //  controllers
            codehaus.groovy.grails.web.pages="error" //  GSP
            codehaus.groovy.grails.web.sitemesh="error" //  layouts
            codehaus.groovy.grails."web.mapping.filter"="error" // URL mapping
            codehaus.groovy.grails."web.mapping"="error" // URL mapping
            codehaus.groovy.grails.commons="info" // core / classloading
            codehaus.groovy.grails.plugins="error" // plugins
            codehaus.groovy.grails.orm.hibernate="error" // hibernate integration
            springframework="off"
            hibernate="off"
        }
    }
    additivity.StackTrace=false
}

// WAR dependency config
grails.war.dependencies = [
    "ant.jar",
    "ant-launcher.jar",
    "hibernate3.jar",
    "jdbc2_0-stdext.jar",
    "jta.jar",
    "groovy-all-*.jar",
    "springmodules-sandbox.jar",
    "standard-${servletVersion}.jar",
    "jstl-${servletVersion}.jar",
    "antlr-*.jar",
    "cglib-*.jar",
    "dom4j-*.jar",
    "ehcache-*.jar",
    "junit-*.jar",
    "commons-logging-*.jar",
    "sitemesh-*.jar",
    "spring-*.jar",
    "log4j-*.jar",
    "ognl-*.jar",
    "hsqldb-*.jar",
    "commons-lang-*.jar",
    "commons-collections-*.jar",
    "commons-beanutils-*.jar",
    "commons-pool-*.jar",
    "commons-dbcp-*.jar",
    "commons-cli-*.jar",
    "commons-validator-*.jar",
    "commons-fileupload-*.jar",
    "commons-io-*.jar",
    "commons-io-*.jar",
    "*oro-*.jar",
    "jaxen-*.jar",
    "xercesImpl.jar",
    "xstream-1.2.1.jar",
    "xpp3_min-1.1.3.4.O.jar"
]

grails.war.java5.dependencies = [
    "hibernate-annotations.jar",
    "ejb3-persistence.jar",
]