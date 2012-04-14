package org.basex.test.qt3ts.prod;

import org.basex.tests.bxapi.XQuery;
import org.basex.test.qt3ts.QT3TestSet;

/**
 * Tests for the TreatExpr production.
 *
 * @author BaseX Team 2005-12, BSD License
 * @author Leo Woerteler
 */
@SuppressWarnings("all")
public class ProdTreatExpr extends QT3TestSet {

  /**
   *  A test whose essence is: `3 treat as xs:string`. .
   */
  @org.junit.Test
  public void kSeqExprTreat1() {
    final XQuery query = new XQuery(
      "3 treat as xs:string",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPDY0050")
    );
  }

  /**
   *  Exactly-one xs:integer does not match empty-sequence(). .
   */
  @org.junit.Test
  public void kSeqExprTreat10() {
    final XQuery query = new XQuery(
      "1 treat as empty-sequence()",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPDY0050")
    );
  }

  /**
   *  Implementations using the static typing feature, may raise XPTY0004 because one of the operands to operator 'eq' has cardinality 'one-or-more'. .
   */
  @org.junit.Test
  public void kSeqExprTreat11() {
    final XQuery query = new XQuery(
      "(\"asda\" treat as xs:string +) eq \"asda\"",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertBoolean(true)
      ||
        error("XPTY0004")
      )
    );
  }

  /**
   *  Implementations using the static typing feature, may raise XPTY0004 because one of the operands to operator 'eq' has cardinality 'zero-or-more'. .
   */
  @org.junit.Test
  public void kSeqExprTreat12() {
    final XQuery query = new XQuery(
      "(\"asda\" treat as xs:string *) eq \"asda\"",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertBoolean(true)
      ||
        error("XPTY0004")
      )
    );
  }

  /**
   *  Implementations using the static typing feature, may raise XPTY0004 because one of the operands to the multiply-operator has cardinality 'zero-or-more'. .
   */
  @org.junit.Test
  public void kSeqExprTreat13() {
    final XQuery query = new XQuery(
      "(3 treat as xs:integer * * 3) eq 9",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertBoolean(true)
      ||
        error("XPTY0004")
      )
    );
  }

  /**
   *  A test whose essence is: `(3 treat as xs:integer ? * 3) eq 9`. .
   */
  @org.junit.Test
  public void kSeqExprTreat14() {
    final XQuery query = new XQuery(
      "(3 treat as xs:integer ? * 3) eq 9",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   *  A complex 'treat as' expression, stressing parser and evaluation logic. Implementations supporting the static typing feature may issue XPTY0004. .
   */
  @org.junit.Test
  public void kSeqExprTreat15() {
    final XQuery query = new XQuery(
      "(4 treat as item() + - 5) = ((4 treat as item()+) - 5)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertBoolean(true)
      ||
        error("XPTY0004")
      )
    );
  }

  /**
   *  '3 treat as item(' is a syntatically invalid expression. .
   */
  @org.junit.Test
  public void kSeqExprTreat16() {
    final XQuery query = new XQuery(
      "3 treat as item(",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPST0003")
    );
  }

  /**
   *  A test whose essence is: `(remove((5, 1e0), 2) treat as xs:integer) eq 5`. .
   */
  @org.junit.Test
  public void kSeqExprTreat17() {
    final XQuery query = new XQuery(
      "(remove((5, 1e0), 2) treat as xs:integer) eq 5",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   *  A test whose essence is: `xs:double("3") treat as xs:float`. .
   */
  @org.junit.Test
  public void kSeqExprTreat2() {
    final XQuery query = new XQuery(
      "xs:double(\"3\") treat as xs:float",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPDY0050")
    );
  }

  /**
   *  A test whose essence is: `xs:anyURI("example.com/") treat as xs:float`. .
   */
  @org.junit.Test
  public void kSeqExprTreat3() {
    final XQuery query = new XQuery(
      "xs:anyURI(\"example.com/\") treat as xs:float",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPDY0050")
    );
  }

  /**
   *  A test whose essence is: `3.0 treat as xs:integer`. .
   */
  @org.junit.Test
  public void kSeqExprTreat4() {
    final XQuery query = new XQuery(
      "3.0 treat as xs:integer",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPDY0050")
    );
  }

  /**
   *  A test whose essence is: `xs:integer(3) treat as xs:decimal instance of xs:integer`. .
   */
  @org.junit.Test
  public void kSeqExprTreat5() {
    final XQuery query = new XQuery(
      "xs:integer(3) treat as xs:decimal instance of xs:integer",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   *  A test whose essence is: `"3" treat as xs:string eq '3'`. .
   */
  @org.junit.Test
  public void kSeqExprTreat6() {
    final XQuery query = new XQuery(
      "\"3\" treat as xs:string eq '3'",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   *  A test whose essence is: `xs:integer("3") treat as xs:decimal instance of xs:decimal`. .
   */
  @org.junit.Test
  public void kSeqExprTreat7() {
    final XQuery query = new XQuery(
      "xs:integer(\"3\") treat as xs:decimal instance of xs:decimal",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   *  A type is specified which doesn't exist. .
   */
  @org.junit.Test
  public void kSeqExprTreat8() {
    final XQuery query = new XQuery(
      "3 treat as prefixDoesNotExist:integer",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPST0081")
    );
  }

  /**
   *  A type is specified which doesn't exist. .
   */
  @org.junit.Test
  public void kSeqExprTreat9() {
    final XQuery query = new XQuery(
      "3 treat as xs:doesNotExist",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPST0051")
    );
  }

  /**
   *  An xs:decimal, despite being a valid integer, cannot be treated as an xs:integer. .
   */
  @org.junit.Test
  public void k2SeqExprTreat1() {
    final XQuery query = new XQuery(
      "xs:decimal(3) treat as xs:integer",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPDY0050")
    );
  }

  /**
   *  Use three pluses on a row, combined with 'treat as'. .
   */
  @org.junit.Test
  public void k2SeqExprTreat2() {
    final XQuery query = new XQuery(
      "3 treat as item()+ + +1",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("4")
    );
  }

  /**
   *  Lhs must be a StepExpr, and TreatExpr is not. .
   */
  @org.junit.Test
  public void k2SeqExprTreat3() {
    final XQuery query = new XQuery(
      "fn:root(self::node()) treat as document-node()/X",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPST0003")
    );
  }

  /**
   *  Treat the result of an empty node test, as the empty-sequence(). .
   */
  @org.junit.Test
  public void k2SeqExprTreat4() {
    final XQuery query = new XQuery(
      "empty(<e/>/(* treat as empty-sequence()))",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   *  Evaluation of treat as expression where the dynamic type does not match expected type. .
   */
  @org.junit.Test
  public void treatAs1() {
    final XQuery query = new XQuery(
      "let $var := (100+200) div 2 return fn:concat($var treat as xs:string,\"a string\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPDY0050")
    );
  }

  /**
   *  Evaluation of treat as expression where involving an xs:dateTime data type and fn:minutes-from-dateTime function. .
   */
  @org.junit.Test
  public void treatAs10() {
    final XQuery query = new XQuery(
      "let $var := xs:dateTime(\"1999-05-31T13:20:00-05:00\") return fn:minutes-from-dateTime($var treat as xs:dateTime)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("20")
    );
  }

  /**
   *  Evaluation of treat as expression where involving an xs:time data type and fn:hours-from-time function. .
   */
  @org.junit.Test
  public void treatAs11() {
    final XQuery query = new XQuery(
      "let $var := xs:time(\"01:23:00+05:00\") return fn:hours-from-time($var treat as xs:time)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("1")
    );
  }

  /**
   *  Evaluation of treat as expression where involving an xs:integer data type and a homogeneous sequence. .
   */
  @org.junit.Test
  public void treatAs12() {
    final XQuery query = new XQuery(
      "let $var := 100 return ($var treat as xs:integer, $var treat as xs:integer, $var treat as xs:integer)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertStringValue(false, "100 100 100")
    );
  }

  /**
   *  Evaluation of treat as expression where involving an xs:integer data type and a heterogeneous sequence. .
   */
  @org.junit.Test
  public void treatAs13() {
    final XQuery query = new XQuery(
      "let $var := 100 return (xs:decimal($var) treat as xs:decimal, xs:double($var) treat as xs:double, xs:float($var) treat as xs:float, $var treat as xs:integer)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertStringValue(false, "100 100 100 100")
    );
  }

  /**
   *  Evaluation of treat as expression with a "cast as" expression and integer/float data types. .
   */
  @org.junit.Test
  public void treatAs14() {
    final XQuery query = new XQuery(
      "let $var := -100 return fn:abs($var cast as xs:float treat as xs:float)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression with a "cast as" expression and integer/double data types. .
   */
  @org.junit.Test
  public void treatAs15() {
    final XQuery query = new XQuery(
      "let $var := -100 return fn:abs($var cast as xs:double treat as xs:double)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression with a "cast as" expression and float/integer data types. .
   */
  @org.junit.Test
  public void treatAs16() {
    final XQuery query = new XQuery(
      "let $var := xs:float(-100) return fn:abs($var cast as xs:integer treat as xs:integer)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression with a "cast as" expression and double/integer data types. .
   */
  @org.junit.Test
  public void treatAs17() {
    final XQuery query = new XQuery(
      "let $var := xs:double(-100) return fn:abs($var cast as xs:integer treat as xs:integer)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression with a "cast as" expression and double/float data types. .
   */
  @org.junit.Test
  public void treatAs18() {
    final XQuery query = new XQuery(
      "let $var := xs:double(-100) return fn:abs($var cast as xs:float treat as xs:float)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression with a "cast as" expression and float/double data types. .
   */
  @org.junit.Test
  public void treatAs19() {
    final XQuery query = new XQuery(
      "let $var := xs:float(-100) return fn:abs($var cast as xs:double treat as xs:double)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression where involving a string data type. .
   */
  @org.junit.Test
  public void treatAs2() {
    final XQuery query = new XQuery(
      "let $var := \"String 1\" return fn:concat($var treat as xs:string,\"String 2\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertStringValue(false, "String 1String 2")
    );
  }

  /**
   *  Evaluation of treat as expression with a "cast as" expression and decimal/double data types. .
   */
  @org.junit.Test
  public void treatAs20() {
    final XQuery query = new XQuery(
      "let $var := xs:decimal(-100) return fn:abs($var cast as xs:double treat as xs:double)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression with a "cast as" expression and decimal/float data types. .
   */
  @org.junit.Test
  public void treatAs21() {
    final XQuery query = new XQuery(
      "let $var := xs:decimal(-100) return fn:abs($var cast as xs:float treat as xs:float)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression with a "cast as" expression and float/decimal data types (float cast as decimal treat as decimal). .
   */
  @org.junit.Test
  public void treatAs22() {
    final XQuery query = new XQuery(
      "let $var := xs:float(-100) return fn:abs($var cast as xs:decimal treat as xs:decimal)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression with a "cast as" expression and double/decimal data types (double cast as decimal treat as decimal). .
   */
  @org.junit.Test
  public void treatAs23() {
    final XQuery query = new XQuery(
      "let $var := xs:double(-100) return fn:abs($var cast as xs:decimal treat as xs:decimal)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression used as part of an addition operation. .
   */
  @org.junit.Test
  public void treatAs24() {
    final XQuery query = new XQuery(
      "let $var := (100+200) div 10 return ($var cast as xs:integer treat as xs:integer) + 10",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("40")
    );
  }

  /**
   *  Evaluation of treat as expression used as part of an subtraction operation. .
   */
  @org.junit.Test
  public void treatAs25() {
    final XQuery query = new XQuery(
      "let $var := (100+200) div 10 return ($var cast as xs:integer treat as xs:integer) - 10",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("20")
    );
  }

  /**
   *  Evaluation of treat as expression where involving an integer data type and div expression. .
   */
  @org.junit.Test
  public void treatAs3() {
    final XQuery query = new XQuery(
      "let $var := 100 return ($var treat as xs:integer) div 2",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("50")
    );
  }

  /**
   *  Evaluation of treat as expression where involving an integer data type and div expression. .
   */
  @org.junit.Test
  public void treatAs4() {
    final XQuery query = new XQuery(
      "let $var := 100 return fn:abs($var treat as xs:decimal)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression where involving an decimal/integer data types and abs function. decimal treated as integer .
   */
  @org.junit.Test
  public void treatAs5() {
    final XQuery query = new XQuery(
      "let $var := xs:decimal(100) return fn:abs($var cast as xs:integer treat as xs:integer)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression where involving an xs:float data types and abs function. .
   */
  @org.junit.Test
  public void treatAs6() {
    final XQuery query = new XQuery(
      "let $var := xs:float(100) return fn:abs($var treat as xs:float)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression where involving an xs:double data type and abs function. .
   */
  @org.junit.Test
  public void treatAs7() {
    final XQuery query = new XQuery(
      "let $var := xs:double(100) return fn:abs($var treat as xs:double)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("100")
    );
  }

  /**
   *  Evaluation of treat as expression where involving an xs:boolean data type and fn:not function. .
   */
  @org.junit.Test
  public void treatAs8() {
    final XQuery query = new XQuery(
      "let $var := xs:boolean(fn:true()) return fn:not($var treat as xs:boolean)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(false)
    );
  }

  /**
   *  Evaluation of treat as expression where involving an xs:date data type and fn:year-from-date function. .
   */
  @org.junit.Test
  public void treatAs9() {
    final XQuery query = new XQuery(
      "let $var := xs:date(\"2000-01-01+05:00\") return fn:year-from-date($var treat as xs:date)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("2000")
    );
  }
}
