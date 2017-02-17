/* {InvalidDocTypeException.java}
 * 
 * An Exception for handling invalid EDI Document Types.
 * 
 * Copyright (C) 2017 Integrity Solutions
 *
 * This source code is protected by US and International Copyright 
 * Laws and Treaties. All code contained is proprietary information
 * and may not be divulged or disclosed to any third party without
 * the direct, written consent of the officers of Integrity Solutions.
 */
package com.is2300.jedi.edi.global.exceptions;

/**
 * The <tt>InvalidDocTypeException</tt> is for catching invalid EDI Document
 * Types that may be passed through EDI transmission files.
 * 
 * @author Sean Carrick
 * &lt;<a href="mailto:PekinSOFT@outlook.com">PekinSOFT@outlook.com</a>&gt;
 * @version 0.5.0
 * @since 0.5.0
 */
public class InvalidDocTypeException extends Exception {

    /**
     * Creates a new instance of <code>InvalidDocTypeException</code> without
     * detail message.
     */
    public InvalidDocTypeException() {
        super();
    }

    /**
     * Constructs an instance of <code>InvalidDocTypeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidDocTypeException(String msg) {
        super(msg);
    }
}
