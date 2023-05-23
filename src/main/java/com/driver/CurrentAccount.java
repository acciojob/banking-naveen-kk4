package com.driver;



import java.util.Optional;
import java.util.PriorityQueue;



public class CurrentAccount extends BankAccount{
    private String tradeLicenseId;
    private static double minimumBalance = 5000;


    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance,minimumBalance);
        if(balance<this.minimumBalance)throw new Exception("insufficient balance");
        this.tradeLicenseId=tradeLicenseId;
    }
    public boolean isValid(String s){
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1))return false;
        }
        return true;
    }
    public Optional<String> getString(String str){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)->Integer.compare(y.freq,x.freq));
        int freq[] = new int[26];
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            freq[ch-'a']++;

        }
        for(int i = 0;i<26;i++){
            if(freq[i]!=0)pq.add(new Pair((char)(i+'a'),freq[i]));
        }
        StringBuilder ans = new StringBuilder();
        Pair a = null;
        while(pq.size()!=0){
            Pair p = pq.poll();
            ans.append(p.ch);
            if(a!=null && a.freq>0){
                pq.add(a);
            }
            p.freq--;
            a=p;
        }

        return ans.length()==str.length()?Optional.of(ans.toString()):Optional.empty();
    }

    public void validateLicenseId() throws Exception {
        if(isValid(this.tradeLicenseId))return;
        Optional<String> ans = getString(this.tradeLicenseId);
        if(ans.isEmpty())throw new Exception( "Valid License can not be generated");
        this.tradeLicenseId = ans.get();

    }

}
