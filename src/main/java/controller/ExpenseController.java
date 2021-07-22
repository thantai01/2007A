package controller;

import model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.expense.IExpenseService;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/expense-manager")

public class ExpenseController {
    @Autowired
    private IExpenseService expenseService;

    @GetMapping("")
    public ModelAndView expenseList() {
        ModelAndView modelAndView = new ModelAndView("expense/list");
        Iterable<Expense> expenses = expenseService.findAll();
        List<Expense> expenseList = new ArrayList<>((Collection<? extends Expense>) expenses);
        modelAndView.addObject("expenses",expenseList);
        return modelAndView;
    }
    @GetMapping("/create")
    public String createExpense(@RequestParam int type, String name,double payment,String description) {
        expenseService.save(new Expense(type,name,payment,description));
        return "redirect:/expense-manager";
    }
    @GetMapping("{id}/detail")
    public String expenseDetail(@PathVariable long id, Model model) {
        Optional<Expense> expense = expenseService.findById(id);
        if(expense.isPresent()) {
            model.addAttribute("ex",expense.get());
            return "expense/detail";
        } else {
            model.addAttribute("message","Expense not found");
            return "expense/list";
        }
    }

}
