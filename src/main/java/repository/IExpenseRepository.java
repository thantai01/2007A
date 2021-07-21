package repository;

import model.Expense;
import org.springframework.data.repository.CrudRepository;

public interface IExpenseRepository extends CrudRepository<Expense,Long> {
}
