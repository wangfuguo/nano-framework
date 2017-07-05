/*
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nanoframework.concurrent.scheduler.cluster;

import javax.servlet.ServletConfig;

import org.nanoframework.concurrent.scheduler.loader.SchedulerLoader;
import org.nanoframework.core.plugins.Plugin;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 *
 * @author yanghe
 * @since 1.4.8
 */
public class SchedulerClusterPlugin implements Plugin {

    @Inject
    @Named("cluster")
    private SchedulerLoader loader;

    @Override
    public boolean load() throws Throwable {
        loader.load();
        return true;
    }

    @Override
    public void config(final ServletConfig config) throws Throwable {

    }

}
