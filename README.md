# dynamic-cache
Ability to change cache manager at runtime

#How to get started
1. Clone the repository
2. Run the Application
3. Use curl localhost:8080 to get the data. Default cache manager is ConcurrentMap cache manager
4. Use curl -X PUT localhost:8080/modify/NO_OP to change the cache manager and not use cache
5. Use curl localhost:8080 to get the data and verify that the implementation is called

#How to extend usecase
1. Add the enum value in CacheType
2. Create the cacheManager bean in Application class
3. Modify CacheResolver class to add the new cache manager