/* {DocTypeValidator.java}
 * 
 * This class has one (1) method to override in order to use to validate EDI 
 * document type codes.
 *
 * This API needs to be included in *any* module that needs to perform any 
 * validation of EDI Document Type codes.
 * 
 * Copyright (C) 2017 Integrity Solutions
 *
 * This source code is protected by US and International Copyright 
 * Laws and Treaties. All code contained is proprietary information
 * and may not be divulged or disclosed to any third party without
 * the direct, written consent of the officers of Integrity Solutions.
 */
package com.is2300.jedi.edi.global.utils;

import org.openide.util.lookup.ServiceProvider;

/**
 * The <tt>DocTypeValidator</tt> API interface provides only one (1) public 
 * method, which needs to be overriden for the specific use of the program,
 * by which the various document type classes can perform validation on the 
 * document type codes provided to them through the incoming EDI file segment
 * data fields.
 * <p>
 * There are almost 1,000 different EDI document types, so this API provides an
 * <tt>Interface</tt> to allow a specific module to be able to create a
 * validation class for validating the provided EDI document types. EDI document
 * types are varied by industry:
 * <ul>
 *  <li>Banking</li>
 *  <li>Financial Services</li>
 *  <li>Insurance</li>
 *  <li>Legal Services</li>
 *  <li>Logistics</li>
 *  <li>Manufacturing</li>
 *  <li>Medical</li>
 *  <li>Real Estate</li>
 * </ul>
 * <p>
 * Therefore, there are many different document types that need to be validated.
 * the <tt>validate()</tt> method examines the provided document type and 
 * determines whether or not it is a valid EDI document type.
 * 
 * @author Sean Carrick &lt;<a href="mailto:PekinSOFT@outlook.com">PekinSOFT@outlook.com</a>&gt;
 * @version <strong><em>Program:</em></strong> 0.5.0
 * @since 0.5.0
 */
public interface DocTypeValidator {
    /**
     * The <tt>validate()</tt> method checks the validity of the supplied EDI
     * document type code. This method is able to check the validity of <strong>
     * all</strong> EDI document types, regardless of industry. This method will
     * need to be updated whenever the ANSI X11 Committee adds new document 
     * types to the standards.
     * 
     * @param docType a <tt>java.lang.String</tt> representation of the EDI
     *                document type code
     * @return <tt>true</tt> if the EDI document type is valid; <tt>false</tt>
     *          otherwise
     */
    Boolean validate(String docType);
}
