package Parsers;

public class parserInt implements parser
{
    @Override
    public Object parse(String s)
    {
        return Integer.parseInt(s);
    }
}