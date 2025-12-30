package com.crud.service;

import com.crud.entity.FAQ;

import java.util.List;

public interface FAQService {

    FAQ addFAQ(FAQ faq);
    FAQ updateFAQ(Long id, FAQ faq);
    void deleteFAQ(Long id);
    List<FAQ> getAllFAQs();
    FAQ getFAQById(Long id);


}
