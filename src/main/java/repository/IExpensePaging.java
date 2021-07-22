package repository;

import model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface IExpensePaging extends PagingAndSortingRepository<Expense,Long> {
    @Override
    Page<Expense> findAll(Pageable pageable);

    @Override
    Iterable<Expense> findAll(Sort sort);
}
