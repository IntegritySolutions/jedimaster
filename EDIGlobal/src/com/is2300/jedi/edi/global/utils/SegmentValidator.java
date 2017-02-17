/* {SegmentValidator.java}
 * 
 * Allows programs to validate the EDI Document Segment Codes, i.e., BEG, LIN,
 * etc.
 * 
 * Copyright (C) 2017 Integrity Solutions
 *
 * This source code is protected by US and International Copyright 
 * Laws and Treaties. All code contained is proprietary information
 * and may not be divulged or disclosed to any third party without
 * the direct, written consent of the officers of Integrity Solutions.
 */
package com.is2300.jedi.edi.global.utils;

/**
 * A simple API for validating EDI Document Segment Codes. Since each EDI 
 * Document Type has different Segment requirements, this Validator API will 
 * need to be implemented on a document-by-document basis so that the document's
 * segments can be validated.
 * 
 * @author Sean Carrick
 * &lt;<a href="mailto:PekinSOFT@outlook.com">PekinSOFT@outlook.com</a>&gt;
 * @version 0.5.0
 * @since 0.5.0
 */
public interface SegmentValidator {
    boolean validate(String segment);
}
