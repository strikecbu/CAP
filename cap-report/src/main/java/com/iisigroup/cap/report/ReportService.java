/*
 * IReportService.java
 *
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.report;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.exception.CapException;

/**
 * <p>
 * 報表處理的主要介面，主要是產生檔案及計算頁面兩種方法。
 * </p>
 * 
 * @author Sunkist Wang
 * @version
 *          <ul>
 *          <li>2011/6/13,Sunkist,new
 *          </ul>
 */
public interface ReportService {

    /**
     * report action
     * 
     * @param request
     *            request
     * @return report data
     * @throws CapException
     */
    Map<String, Object> excute(Request request);

    /**
     * 報表產生的共同進入方法，帶入reportParameter，產生ByteArray的報表檔案。
     * 
     * @param params
     *            PageParameters
     * @param comp
     *            Component
     * @return ByteArrayOutputStream
     * @throws CapException
     */
    ByteArrayOutputStream generateReport(Request request) throws CapException;

    /**
     * Gets the report definition.從ReportDirectory之後的完整路徑 如：batch/jobExecutionResult
     * 
     * @return the report definition
     */
    public abstract String getReportDefinition();

    /**
     * 是否寫檔
     * 
     * @return boolean
     */
    public abstract boolean isWriteToFile();

}
