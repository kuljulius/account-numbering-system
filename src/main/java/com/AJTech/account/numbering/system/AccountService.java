package com.AJTech.account.numbering.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public AccountGeneration generateAccountNumber(AccountGeneration accountGeneration){
        int even =0, odd=0;
        int check_digit=0;
        String Aphabeth ="A";
        Random rd = new Random();

        int[] arr = new int[10];
        int i;
        for (i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(9)+1;
            if (i%2!=0){
                odd += arr[i];
                System.out.println(i);
            }else{
                even += arr[i];

            }

        }
        System.out.println("odd "+ odd);

        odd *=3;
        System.out.println(odd);

        String answer = Arrays.toString(arr);
        System.out.println("Answer "+ answer);

        check_digit = (even *=odd)%10;
        String s = Integer.toString(check_digit);
        String accountNumber = Aphabeth + answer + s;
        String accountGenerated = accountNumber.replaceAll("(?<=\\d)", "")
                .replaceAll("\\[|\\]", "")
                .replaceAll(",", "").replaceAll("\\s", "");
        System.out.println("accountgenerated "+ accountGenerated);
        AccountGeneration produce = accountGeneration.setAccountNumber(accountGenerated);
        System.out.println("produce "+ produce);
        repository.save(produce);
        return produce;
    }
}
