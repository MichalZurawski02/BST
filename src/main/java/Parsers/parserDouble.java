package Parsers;

public class parserDouble implements parser
{
    @Override
    public Object parse(String s)
    {
        return Double.parseDouble(s);
    }
}