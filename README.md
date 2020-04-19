# YopJava
基于YOP开放平台的SDK


cat city.txt|awk -F',' '{print "public final static String SHORT_"toupper($8)" = \""$8"\"; // "$6}'
cat country.txt|awk -F',' '{print "public final static String COUNTRY_"toupper($1)" = \""$1"\"; // "$5}'
cat airport.txt|sort -t ',' -k 7|awk -F',,,' '{print "public final static String AIRPORT_"toupper($3)"_"toupper($1)" = \""$1"\"; // "$2}'

LUM,,,德宏芒市机场,,,芒市,,,0,,,0,,,,,,,,,,,,