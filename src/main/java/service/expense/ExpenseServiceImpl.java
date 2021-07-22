package service.expense;

import model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.IExpensePaging;
import repository.IExpenseRepository;

import java.util.Optional;

@Service
public class ExpenseServiceImpl implements IExpenseService{
    @Autowired
    private IExpenseRepository iExpenseRepository;
    @Autowired
    private IExpensePaging iExpensePaging;

    @Override
    public Iterable<Expense> findAll() {
        return iExpenseRepository.findAll();
    }

    @Override
    public Optional<Expense> findById(Long id) {
        return iExpenseRepository.findById(id);
    }

    @Override
    public void save(Expense expense) {
        iExpenseRepository.save(expense);
    }

    @Override
    public void remove(Long id) {
        iExpenseRepository.deleteById(id);
    }

    public Page<Expense> showPageList(Pageable pageable) {
        return iExpensePaging.findAll(pageable);
    }
}
