package repository;

import model.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpenseRepository extends CrudRepository<Expense,Long> {

}
