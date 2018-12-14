package com.test.pultrik.controller.form;

import com.test.pultrik.model.Operator;
import com.test.pultrik.model.Transaksi;
import com.test.pultrik.model.Voucher;
import com.test.pultrik.model.payload.Login;
import com.test.pultrik.model.payload.Response;
import com.test.pultrik.model.payload.TransactionForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

@Controller
public class LoginCtl {

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String formLogin(Login login) {
        return "login";
    }

    @PostMapping("/login_process")
    public String loginProcess(@ModelAttribute("login") Login login, RedirectAttributes redir)throws URISyntaxException {
        final String baseUrl = "http://localhost:8080/api/login";
        URI uri = new URI(baseUrl);
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Response> resp = rest.postForEntity(uri, login, Response.class);
        Response response = resp.getBody();
        HashMap<String, Long> log = (HashMap<String, Long>) response.getData();
        if (response.getStatus().equalsIgnoreCase("0")) {
            redir.addFlashAttribute("idUser", log.get("idUser"));
            return "redirect:/transaksi";
        } else {
            redir.addFlashAttribute("error", response.getMessage());
            return "redirect:/login";
        }
    }

    @GetMapping("/transaksi")
    public ModelAndView formTransaksi(Model model, TransactionForm form)throws URISyntaxException {
        List<Operator> lst1 = getOperator();
        //List<Voucher> lst2 = getVoucher(1);
        model.addAttribute("allOperator", lst1);
        //model.addAttribute("allVoucher", lst2);
        ModelAndView mView = new ModelAndView();
        mView.setViewName("transaksi");
        mView.addObject("form", new TransactionForm());
        return mView;
    }

    @PostMapping("/transaksi_process")
    public String transaksiProcess(@ModelAttribute("transaction") TransactionForm form, Model redir) throws URISyntaxException{

        Transaksi transaksi = new Transaksi();
        transaksi.setNoHp(form.getNoHp());
        transaksi.setHarga(form.getHarga());
        final String baseUrl = "http://localhost:8080/api/transaksi/"+form.getIdUser()+"/"+form.getIdVoucher();
        URI uri = new URI(baseUrl);
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Response> resp = rest.postForEntity(uri, transaksi, Response.class);
        Response response = resp.getBody();
//        if (!Utility.validateForm("^[0-9]+$", form.getNoHp())) {
//            redir.addFlashAttribute("error", response.getMessage());
//            return "redirect:/transaksi";
//        }
        if (response.getStatus().equalsIgnoreCase("0")) {
            return "redirect:/transaksi";
        } else {
            redir.addAttribute("error", response.getMessage());
            List<Operator> lst1 = getOperator();
            //List<Voucher> lst2 = getVoucher(1);
            redir.addAttribute("allOperator", lst1);
            redir.addAttribute("form",new TransactionForm());
            return "transaksi";
        }
    }

    public List<Operator> getOperator()throws URISyntaxException{
        final String baseUrlOperator = "http://localhost:8080/api/operator";
        URI uriOperator = new URI(baseUrlOperator);
        RestTemplate restOperator = new RestTemplate();
        ResponseEntity<Response> resp = restOperator.getForEntity(uriOperator, Response.class);
        List<Operator> lst = (List<Operator>) resp.getBody().getData();
        return lst;
    }

    public List<Voucher> getVoucher(long idOperator)throws URISyntaxException{
        final String baseUrlVoucher = "http://localhost:8080/api/voucher/"+idOperator;
        URI uriVoucher = new URI(baseUrlVoucher);
        RestTemplate restVoucher = new RestTemplate();
        ResponseEntity<Response> resp = restVoucher.getForEntity(uriVoucher, Response.class);
        List<Voucher> lst = (List<Voucher>) resp.getBody().getData();
        return lst;
    }
//
//    @PostMapping("/form")
//    public String formPost(User user, Model model) {
//        model.addAttribute("user", user);
//        return "form";
//    }
}
