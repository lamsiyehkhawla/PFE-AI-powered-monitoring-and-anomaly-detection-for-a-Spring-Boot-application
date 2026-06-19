package ma.enset.ebankingbackend.services;

import ma.enset.ebankingbackend.dtos.*;
import ma.enset.ebankingbackend.enums.AccountStatus;
import ma.enset.ebankingbackend.exceptions.BalanceNotSufficientException;
import ma.enset.ebankingbackend.exceptions.BankAccountNotFoundException;
import ma.enset.ebankingbackend.exceptions.CustomerNotFoundException;

import java.time.LocalDate;
import java.util.List;
public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;

    List<CustomerDTO> getCustomers();

    BankAccountDTO getBankAccountById(String id) throws BankAccountNotFoundException;

    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    List<BankAccountDTO> getAllBankAccounts();

    CustomerDTO getCustomerById(long id) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    void deleteCustomer(long id) throws CustomerNotFoundException;

    List<AccountOperationDTO> getHistory(String id);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);

    List<CustomerDTO> searchCustomer(String keyword);

    List<BankAccountDTO> getAccountsByCustomerId(Long customerId) throws CustomerNotFoundException;

    void updateAccountStatus(String id, AccountStatus status) throws BankAccountNotFoundException;

    void cancelOperation(Long id) throws BankAccountNotFoundException;

    AccountHistoryDTO searchOperations(String accountId, LocalDate startDate, LocalDate endDate,
                                       Double minAmount, Double maxAmount, int page, int size) throws BankAccountNotFoundException;

    BankAccountDTO getLatestAccount();
}
