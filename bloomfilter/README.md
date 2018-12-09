# Bloom Filter

**What kind of problems are commonly solved via bloom filter:**

- Malicious websites and a browser (track malicious URLs)
- Check if a password is weak
- If you have a list of articles and a list of users, you can use bloom filter to show users' articles they have not read
- Bitcoin wallet synchronization
- Akamai's web servers use Bloom filters to prevent "one-hit-wonders" from being stored in its disk caches
- Bloom filters are quite useful in bioinformatics
- Tinder Suggestions -> It fetches a list of guys/girls near you
- Any Unique Identification System has to generate a unique number for newly registered users. If the number of user registrations increase dramatically, checking with the database is too expensive. 
- URL shorteners
- Cache optimization
- Youtube recommendations
- Keep track of the pages that a given user has visited without actually being able to enumerate the links they have visited
- Use a modified version of bloom-filter to efficiently detect and eliminate the boiler plates that occur in the text that we crawl.
- Reduce the number of lookups to the db
- Facebook uses bloom filters for typeahead search, to fetch friends and friends of friends to a user typed query
- LinkedIn also uses bloom filters for type ahead query in a very similar way as Facebook
- Transactional Memory (TM) has recently applied Bloom filters to detect memory access conflicts among threads
- Oracle uses Bloom filters to perform Bloom pruning of partitions for certain queries
- Quora implemented a sharded bloom filter in the feed backend to filter out stories that people have seen before
- Bloom filters have found recent application is embedded systems sensor networks and Internet of Things, especially motes to test for whether a mote can communicate to another mote in the same Ad-hoc network
- Apache HBase uses bloom filter to boost read speed by filtering out unnecessary disk reads of HFile blocks which do not contain a particular row or column
- Cassandra uses bloom filters
 
 # Java implementation for Bloom Filter
 
 - No default JDK implementation
 - Guava Implementation [example](https://www.baeldung.com/guava-bloom-filter)
 - Bloom Filter implementation with hash functions based on SHA-256 and Murmur [example](https://github.com/AnghelLeonard/Java-Data-Structures/tree/master/bloomfilter/BloomFilterImpl)
