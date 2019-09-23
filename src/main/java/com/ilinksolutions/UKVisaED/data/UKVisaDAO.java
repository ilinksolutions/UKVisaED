package com.ilinksolutions.UKVisaED.data;

import java.util.List;

import com.ilinksolutions.UKVisaED.domains.UKVisaMessage;

/**
 *
 */
public interface UKVisaDAO
{
	UKVisaMessage save(UKVisaMessage entry);
    List<UKVisaMessage> list();
    UKVisaMessage getEntry(int id);
    UKVisaMessage updateEntry(int id, UKVisaMessage message);
}
