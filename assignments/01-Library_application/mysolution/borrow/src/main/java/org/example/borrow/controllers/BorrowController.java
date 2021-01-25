package org.example.borrow.controllers;

import org.example.borrow.model.Borrow;
import org.example.borrow.repos.BorrowRepository;
import org.example.borrow.services.NotificationClient;
import org.example.borrow.services.TraceService;
import org.example.borrow.exceptions.BorrowNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@Slf4j
@RequestMapping(value = "/v2/borrows")
public class BorrowController {

    @Autowired
    TraceService traceService;

    @Autowired
    NotificationClient notificationClient;

    @Value("${kafka.sms.message}")
    private String message;

    @Autowired
    private final BorrowRepository borrowRepository;

    public BorrowController(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    // CREATE
    @RequestMapping(method = RequestMethod.PUT)
    public Borrow addNewBorrow(@Valid @RequestBody Borrow borrow) {
        notificationClient.sendSMS(borrow);
        return borrowRepository.save(borrow);
    }


    // READ
    @RequestMapping(value = "/{borrowId}", method = RequestMethod.GET)
    public Borrow getBorrow(@PathVariable Long borrowId) {
        Optional<Borrow> borrowOptional = borrowRepository.findById(borrowId);
        if(borrowOptional.isPresent()){
            return borrowOptional.get();
        }else{
            throw new BorrowNotFoundException();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Borrow> getAllBorrows() {
        log.info("Get all borrows");
        List<Borrow> result = new ArrayList<Borrow>();
        Iterable<Borrow> iterable = borrowRepository.findAll();
        iterable.forEach(result::add);
        return result;
    }


    // UPDATE
    @RequestMapping(value = "/{borrowId}", method = RequestMethod.POST)
    public Borrow modifyBorrow(@RequestBody Borrow borrow, @RequestBody String borrowId ) {
        return borrowRepository.save(borrow);
    }


    // DELETE
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllBorrows() {
        borrowRepository.deleteAll();
    }

    @RequestMapping(value = "/{borrowId}", method = RequestMethod.DELETE)
    public void deleteBorrow(@PathVariable Long borrowId) {
        borrowRepository.deleteById(borrowId);
    }
}
