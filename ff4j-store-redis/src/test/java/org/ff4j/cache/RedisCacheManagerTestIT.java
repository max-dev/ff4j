package org.ff4j.cache;

import org.ff4j.core.Feature;
import org.ff4j.core.FeatureStore;
import org.ff4j.store.InMemoryFeatureStore;
import org.ff4j.test.TestsFf4jConstants;
import org.junit.Assert;
import org.junit.Test;

/*
 * #%L
 * ff4j-cache-redis
 * %%
 * Copyright (C) 2013 - 2014 Ff4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

public class RedisCacheManagerTestIT implements TestsFf4jConstants {

    @Test
    public void testPutGet() {
       
        // Initializing cache manager
        FeatureCacheManager cache = new FeatureCacheProviderRedis();

        // Initializing Features for test
        FeatureStore store = new InMemoryFeatureStore(TEST_FEATURES_FILE);
        Feature fold = store.read(F4);
        
        // Put in Cache
        cache.put(fold);
        
        // Retrieve object
        Feature fcached = cache.get(F4);
        Assert.assertEquals(fcached.getUid(), fold.getUid());
        Assert.assertEquals(fcached.getPermissions(), fold.getPermissions());

    }
}
