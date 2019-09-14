package com.cadastrodepessoas.controller;

import com.cadastrodepessoas.mb.ListPessoaMb;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(servletNames = {"FacesServlet"})
public class ControleDeAcesso implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if ((session.getAttribute("USUARIOLogado") != null)
                || (req.getRequestURI().endsWith("login.xhtml"))
                || (req.getRequestURI().endsWith("cadastroDePessoas/"))
                || (req.getRequestURI().contains("javax.faces.resource/"))) {
            chain.doFilter(request, response);
        } else {
            redireciona(response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    private void redireciona(ServletResponse response) {
        try {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect("../login/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ListPessoaMb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
