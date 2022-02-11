package cookies;

public class CookieChain {

    //IMPORTANT NOTE: I have flipped things that said "cookie" to "CookiesRemade" to fit with the function
    // I had made

    //contains memory address of cookie
    CookiesRemade thisCookie;
    //    contains memory address of next link
    CookieChain nextCookieLink;

    public CookieChain(CookiesRemade c, CookieChain link){
//        all we are doing is manipulating memory addresses
        this.thisCookie = c;
        this.nextCookieLink = link;
    }
}