/*
 * Copyright 2015-2016 the original author or authors.
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
package org.nanoframework.extension.httpclient;

import com.google.inject.Singleton;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.entity.ContentType;
import org.nanoframework.commons.exception.UnsupportedAccessException;
import org.nanoframework.core.component.stereotype.bind.RequestMethod;
import org.nanoframework.extension.httpclient.exception.HttpClientException;
import org.nanoframework.extension.httpclient.inject.HttpConfigure;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author yanghe
 * @since 1.3.3
 */
@Singleton
public class HttpClientImpl extends AbstractHttpClient implements HttpClient {
    /**
     * Default constructor.
     */
    public HttpClientImpl() {
        super();
    }

    /**
     * @param timeToLive 超时时间
     */
    public HttpClientImpl(final long timeToLive) {
        super(timeToLive);
    }

    /**
     * @param timeToLive 超时时间
     * @param charset    字符集
     */
    public HttpClientImpl(final long timeToLive, final Charset charset) {
        super(timeToLive, charset);
    }

    /**
     * @param spi         SPI名称
     * @param timeToLive  超时时间
     * @param tunit       超时时间单位
     * @param maxTotal    最大连接数
     * @param maxPerRoute 最大并发连接数
     * @param charset     字符集
     */
    public HttpClientImpl(final String spi, final long timeToLive, final TimeUnit tunit, final int maxTotal, final int maxPerRoute, final Charset charset) {
        super(spi, timeToLive, tunit, maxTotal, maxPerRoute, charset);
    }

    /**
     * @param conf HttpClient配置
     */
    public HttpClientImpl(final HttpConfigure conf) {
        super(conf);
    }

    @Override
    public HttpResponse get(final String url) throws HttpClientException {
        return process(new HttpGet(url));
    }

    @Override
    public HttpResponse get(final String url, final Map<String, String> params) throws HttpClientException {
        return process(createBase(HttpGet.class, url, params));
    }

    @Override
    public HttpResponse get(final String url, final Map<String, String> headers, final Map<String, String> params) throws HttpClientException {
        return process(createBase(HttpGet.class, url, headers, params));
    }

    @Override
    public HttpResponse post(final String url) throws HttpClientException {
        return process(new HttpPost(url));
    }

    @Override
    public HttpResponse post(final String url, final Map<String, String> params) throws HttpClientException {
        return process(createEntityBase(HttpPost.class, url, params));
    }

    @Override
    public HttpResponse post(final String url, final String json) throws HttpClientException {
        return process(createEntityBase(HttpPost.class, url, json));
    }

    @Override
    public HttpResponse post(final String url, final String stream, final ContentType contentType) throws HttpClientException {
        return process(createEntityBase(HttpPost.class, url, stream, contentType));
    }

    @Override
    public HttpResponse post(final String url, final Map<String, String> headers, final String json) throws HttpClientException {
        return process(createEntityBase(HttpPost.class, url, headers, json));
    }

    @Override
    public HttpResponse post(final String url, final Map<String, String> headers, final String stream, final ContentType contentType)
            throws HttpClientException {
        return process(createEntityBase(HttpPost.class, url, headers, stream, contentType));
    }

    @Override
    public HttpResponse post(final String url, final Map<String, String> headers, final Map<String, String> params) throws HttpClientException {
        return process(createEntityBase(HttpPost.class, url, headers, params));
    }

    @Override
    public HttpResponse put(final String url) throws HttpClientException {
        return process(new HttpPut(url));
    }

    @Override
    public HttpResponse put(final String url, final Map<String, String> params) throws HttpClientException {
        return process(createEntityBase(HttpPut.class, url, params));
    }

    @Override
    public HttpResponse put(final String url, final String json) throws HttpClientException {
        return process(createEntityBase(HttpPut.class, url, json));
    }

    @Override
    public HttpResponse put(final String url, final String stream, final ContentType contentType) throws HttpClientException {
        return process(createEntityBase(HttpPut.class, url, stream, contentType));
    }

    @Override
    public HttpResponse put(final String url, final Map<String, String> headers, final String stream, final ContentType contentType)
            throws HttpClientException {
        return process(createEntityBase(HttpPut.class, url, headers, stream, contentType));
    }

    @Override
    public HttpResponse put(final String url, final Map<String, String> headers, final String json) throws HttpClientException {
        return process(createEntityBase(HttpPut.class, url, headers, json));
    }

    @Override
    public HttpResponse put(final String url, final Map<String, String> headers, final Map<String, String> params) throws HttpClientException {
        return process(createEntityBase(HttpPut.class, url, headers, params));
    }

    @Override
    public HttpResponse delete(final String url) throws HttpClientException {
        return process(new HttpDelete(url));
    }

    @Override
    public HttpResponse delete(final String url, final Map<String, String> params) throws HttpClientException {
        return process(createBase(HttpDelete.class, url, params));
    }

    @Override
    public HttpResponse delete(final String url, final Map<String, String> headers, final Map<String, String> params) throws HttpClientException {
        return process(createBase(HttpDelete.class, url, headers, params));
    }

    @Override
    public HttpResponse patch(final String url) throws HttpClientException {
        return process(new HttpPatch(url));
    }

    @Override
    public HttpResponse patch(final String url, final Map<String, String> params) throws HttpClientException {
        return process(createEntityBase(HttpPatch.class, url, params));
    }

    @Override
    public HttpResponse patch(final String url, final String json) throws HttpClientException {
        return process(createEntityBase(HttpPatch.class, url, json));
    }

    @Override
    public HttpResponse patch(final String url, final String stream, final ContentType contentType) throws HttpClientException {
        return process(createEntityBase(HttpPatch.class, url, stream, contentType));
    }

    @Override
    public HttpResponse patch(final String url, final Map<String, String> headers, final String json) throws HttpClientException {
        return process(createEntityBase(HttpPatch.class, url, headers, json));
    }

    @Override
    public HttpResponse patch(final String url, final Map<String, String> headers, final String stream, final ContentType contentType)
            throws HttpClientException {
        return process(createEntityBase(HttpPatch.class, url, headers, stream, contentType));
    }

    @Override
    public HttpResponse patch(final String url, final Map<String, String> headers, final Map<String, String> params) throws HttpClientException {
        return process(createEntityBase(HttpPatch.class, url, headers, params));
    }

    @Override
    public HttpResponse head(final String url) throws HttpClientException {
        return process(new HttpHead(url));
    }

    @Override
    public HttpResponse head(final String url, final Map<String, String> params) throws HttpClientException {
        return process(createBase(HttpHead.class, url, params));
    }

    @Override
    public HttpResponse head(final String url, final Map<String, String> headers, final Map<String, String> params) throws HttpClientException {
        return process(createBase(HttpHead.class, url, headers, params));
    }

    @Override
    public HttpResponse options(final String url) throws HttpClientException {
        return process(new HttpOptions(url));
    }

    @Override
    public HttpResponse options(final String url, final Map<String, String> params) throws HttpClientException {
        return process(createBase(HttpOptions.class, url, params));
    }

    @Override
    public HttpResponse options(final String url, final Map<String, String> headers, final Map<String, String> params) throws HttpClientException {
        return process(createBase(HttpOptions.class, url, headers, params));
    }

    @Override
    public HttpResponse trace(final String url) throws HttpClientException {
        return process(new HttpTrace(url));
    }

    @Override
    public HttpResponse trace(final String url, final Map<String, String> params) throws HttpClientException {
        return process(createBase(HttpTrace.class, url, params));
    }

    @Override
    public HttpResponse trace(final String url, final Map<String, String> headers, final Map<String, String> params) throws HttpClientException {
        return process(createBase(HttpTrace.class, url, headers, params));
    }

    @Override
    public HttpResponse process(final RequestMethod requestMethod, final String url) throws HttpClientException {
        switch (requestMethod) {
            case GET:
                return get(url);
            case POST:
                return post(url);
            case PUT:
                return put(url);
            case DELETE:
                return delete(url);
            case PATCH:
                return patch(url);
            case HEAD:
                return head(url);
            case OPTIONS:
                return options(url);
            case TRACE:
                return trace(url);
            default:
                throw new UnsupportedAccessException();
        }
    }

    @Override
    public HttpResponse process(final RequestMethod requestMethod, final String url, final Map<String, String> params) throws HttpClientException {
        switch (requestMethod) {
            case GET:
                return get(url, params);
            case POST:
                return post(url, params);
            case PUT:
                return put(url, params);
            case DELETE:
                return delete(url, params);
            case PATCH:
                return patch(url, params);
            case HEAD:
                return head(url, params);
            case OPTIONS:
                return options(url, params);
            case TRACE:
                return trace(url, params);
            default:
                throw new UnsupportedAccessException();
        }
    }

    @Override
    public HttpResponse process(final RequestMethod requestMethod, final String url, final String json) throws HttpClientException {
        switch (requestMethod) {
            case POST:
                return post(url, json);
            case PUT:
                return put(url, json);
            case PATCH:
                return patch(url, json);
            default:
                throw new UnsupportedAccessException();
        }
    }

    @Override
    public HttpResponse process(final RequestMethod requestMethod, final String url, final Map<String, String> headers,
                                final Map<String, String> params) throws HttpClientException {
        switch (requestMethod) {
            case GET:
                return get(url, headers, params);
            case POST:
                return post(url, headers, params);
            case PUT:
                return put(url, headers, params);
            case DELETE:
                return delete(url, headers, params);
            case PATCH:
                return patch(url, headers, params);
            case HEAD:
                return head(url, headers, params);
            case OPTIONS:
                return options(url, headers, params);
            case TRACE:
                return trace(url, headers, params);
            default:
                throw new UnsupportedAccessException();
        }
    }

    @Override
    public HttpResponse process(final RequestMethod requestMethod, final String url, final Map<String, String> headers, final String json)
            throws HttpClientException {
        switch (requestMethod) {
            case POST:
                return post(url, headers, json);
            case PUT:
                return put(url, headers, json);
            case PATCH:
                return patch(url, headers, json);
            default:
                throw new UnsupportedAccessException();
        }
    }

    @Override
    public HttpResponse process(final RequestMethod requestMethod, final String url, final String stream, final ContentType contentType)
            throws HttpClientException {
        switch (requestMethod) {
            case POST:
                return post(url, stream, contentType);
            case PUT:
                return put(url, stream, contentType);
            case PATCH:
                return patch(url, stream, contentType);
            default:
                throw new UnsupportedAccessException();
        }
    }

    @Override
    public HttpResponse process(final RequestMethod requestMethod, final String url, final Map<String, String> headers, final String stream,
                                final ContentType contentType) throws HttpClientException {
        switch (requestMethod) {
            case POST:
                return post(url, headers, stream, contentType);
            case PUT:
                return put(url, headers, stream, contentType);
            case PATCH:
                return patch(url, headers, stream, contentType);
            default:
                throw new UnsupportedAccessException();
        }
    }

}
