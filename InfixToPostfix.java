import java.util.*;

public class InfixToPostfix
{
  static int evaluation(String postfix)
  {
    int n = postfix.length();
    if(n==0)
      return 0;
    Stack<Integer> s = new Stack<>();
    for(int i=0;i<n;i++)
    {
      char ch  = postfix.charAt(i);
      if(ch>='0' && ch<='9')
      {
        s.push(ch-'0');
        System.out.println(s);
      }
      else
      {
        int a = s.pop();
        int b = s.pop();
        if(ch=='+')
          s.push(b+a);
        else if(ch=='-')
          s.push(b-a);
        else if(ch=='*')
          s.push(b*a);
        else if(ch=='/')
        {
          if(a==0)
          {
            System.out.println("Cannot divide by zero");
            return -1;
          }
          s.push((int)b/a);
        }
        else if(ch=='%')
        {
          if(a==0)
          {
            System.out.println("Cannot divide by zero");
            return -1;
          }
          s.push(b%a);
        }
      }
      
    }
    return s.peek();
  }
  static boolean isoperator(char ch)
  {
    return ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='%' ||  ch=='^' ;
    
  }
  static int precedence(char ch)
  {
    if(ch=='+' || ch=='-')
      return 1;
    else if(ch=='*' || ch=='/' || ch=='%')
      return 2;
    else if(ch=='^')
      return 3;
    return -1;
  }
  static String infixtopostfix(String str)
  {
    int n = str.length();
    if(n==0)
      return "";
    Stack<Character> s = new Stack<>();
    String postfix = "";
    for(int i=0;i<n;i++)
    {
      char ch = str.charAt(i);
      if(ch==' ')
        continue;
      else if(isoperator(ch)) 
      {
        while(!s.empty() && precedence(ch)<=precedence(s.peek()))
          postfix+=s.pop();
          
        s.push(ch);
      }
      else if(ch=='(')
        s.push(ch);
      else if(ch==')')
      {
        while(!s.empty() && s.peek()!='(')
          postfix+=s.pop();
          
        if(!s.empty())
          s.pop();
        if(s.empty())
          return "Invalid Expression";
      }
      else
        postfix+=ch;
    }
    while(!s.empty())
    {
      if(s.peek()=='(')
        return "Invalid Expression";
      postfix+=s.pop();
    }
    return postfix;
  }
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(evaluation(infixtopostfix(str)));
  }
}