/*
 * Copyright 1999-2101 Alibaba Group Holding Ltd.
 *
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
 */
package org.nanoframework.commons.support.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Jdk14LoggingImpl implements org.nanoframework.commons.support.logging.Logger {

    private Logger log;

    private int    errorCount;
    private int    warnCount;
    private int    infoCount;
    private int    debugCount;

    private String loggerName;

    public Jdk14LoggingImpl(String loggerName){
        this.loggerName = loggerName;
        log = Logger.getLogger(loggerName);
    }

    public boolean isDebugEnabled() {
        return log.isLoggable(Level.FINE);
    }

    public void error(String s, Throwable e) {
        log.logp(Level.SEVERE, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), s, e);
        errorCount++;
    }

    public void error(String s) {
        log.logp(Level.SEVERE, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), s);
        errorCount++;
    }

    public void debug(String s) {
        debugCount++;
        log.logp(Level.FINE, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), s);
    }

    public void debug(String s, Throwable e) {
        debugCount++;
        log.logp(Level.FINE, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), s, e);
    }

    public void warn(String s) {
        log.logp(Level.WARNING, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), s);
        warnCount++;
    }

    @Override
    public void warn(String s, Throwable e) {
        log.logp(Level.WARNING, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), s, e);
        warnCount++;
    }

    @Override
    public int getWarnCount() {
        return warnCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    @Override
    public void resetStat() {
        errorCount = 0;
        warnCount = 0;
        infoCount = 0;
        debugCount = 0;
    }

    @Override
    public boolean isInfoEnabled() {
        return log.isLoggable(Level.INFO);
    }

    @Override
    public void info(String msg) {
        log.logp(Level.INFO, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), msg);
        infoCount++;
    }

    @Override
    public int getInfoCount() {
        return infoCount;
    }

    @Override
    public boolean isWarnEnabled() {
        return log.isLoggable(Level.WARNING);
    }

    public int getDebugCount() {
        return debugCount;
    }

	@Override
	public void warn(String paramString, Object[] paramArrayOfObject) {
		log.logp(Level.WARNING, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), paramString, paramArrayOfObject);
        warnCount++;
	}

	@Override
	public void warn(Throwable paramThrowable) {
		log.logp(Level.WARNING, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), null, paramThrowable);
        warnCount++;
	}

	@Override
	public void info(String paramString, Object[] paramArrayOfObject) {
		log.logp(Level.INFO, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), paramString, paramArrayOfObject);
		infoCount++;
	}

	@Override
	public void info(Throwable paramThrowable) {
		log.logp(Level.INFO, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), null, paramThrowable);
		infoCount++;
	}

	@Override
	public void info(String paramString, Throwable paramThrowable) {
		log.logp(Level.INFO, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), paramString, paramThrowable);
		infoCount++;
	}

	@Override
	public void debug(String paramString, Object[] paramArrayOfObject) {
		log.logp(Level.FINE, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), paramString, paramArrayOfObject);
		debugCount++;
	}

	@Override
	public void debug(Throwable paramThrowable) {
		log.logp(Level.FINE, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), null, paramThrowable);
		debugCount++;
	}

	@Override
	public void error(String paramString, Object[] paramArrayOfObject) {
		log.logp(Level.SEVERE, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), paramString, paramArrayOfObject);
		errorCount++;
	}
	
	@Override
	public void error(Throwable paramThrowable) {
		log.logp(Level.SEVERE, loggerName, Thread.currentThread().getStackTrace()[1].getMethodName(), null, paramThrowable);
		errorCount++;
	}
}
