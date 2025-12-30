package com.crud.serviceimpl;

import com.crud.entity.FAQ;
import com.crud.repository.FAQRepository;
import com.crud.service.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FAQServiceImpl implements FAQService {

    @Autowired
    private FAQRepository faqRepository;

    @Override
    public FAQ addFAQ(FAQ faq) {
        return faqRepository.save(faq);
    }

    @Override
    public FAQ updateFAQ(Long id, FAQ faq) {
        FAQ existing = faqRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FAQ not found"));
        existing.setQuestion(faq.getQuestion());
        existing.setAnswer(faq.getAnswer());
        return faqRepository.save(existing);
    }

    @Override
    public void deleteFAQ(Long id) {
        faqRepository.deleteById(id);

    }

    @Override
    public List<FAQ> getAllFAQs() {
        return faqRepository.findAll();
    }

    @Override
    public FAQ getFAQById(Long id) {
       return faqRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FAQ not found"));
    }
}
