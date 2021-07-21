package service.expense;

import model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IExpenseRepository;

import java.util.Optional;

@Service
public class ExpenseServiceImpl implements IExpenseService{
    @Autowired
    private IExpenseRepository iExpenseRepository;

    @Override
    public Iterable<Expense> findAll() {
        return iExpenseRepository.findAll();
    }

    @Override
    public Optional<Expense> findById(Long id) {
        Optional<Expense> expense = iExpenseRepository.findById(id);
        return Optional.empty();
    }

    @Override
    public void save(Expense expense) {
        iExpenseRepository.save(expense);
    }

    @Override
    public void remove(Long id) {
        iExpenseRepository.deleteById(id);
    }
}
