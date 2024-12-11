package y2k;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class RT {

  public static List<Object> rest(Object xs) {
    var col = (List<Object>) xs;
    return col.subList(1, col.size());
  }

  public static boolean equals(Object a, Object b) {
    return java.util.Objects.equals(a, b);
  }

  public static Map<Object, Object> hash_map(Object... args) {
    var result = new HashMap<Object, Object>();
    for (int i = 0; i < args.length; i += 2) {
      result.put(args[i], args[i + 1]);
    }
    return result;
  }

  public static int count(Object xs) {
    return ((List) xs).size();
  }

  public static <T, R> Function<T, R> function(Function<T, R> f) {
    return f;
  }

  public static Map<Object, Object> merge(Object as, Object bs) {
    var a = (Map<Object, Object>) as;
    var b = (Map<Object, Object>) bs;
    var result = new HashMap<>(a);
    result.putAll(b);
    return result;
  }

  public static List<Object> concat(Object as, Object bs) {
    var a = (List<Object>) as;
    var b = (List<Object>) bs;
    var result = new ArrayList<>(a);
    result.addAll(b);
    return result;
  }

  public static Map<Object, Object> assoc(Object xs, Object k, Object v) {
    var col = (Map<Object, Object>) xs;
    var result = new HashMap<>(col);
    result.put(k, v);
    return result;
  }

  public static boolean empty(Object xs) {
    return ((List) xs).isEmpty();
  }

  public static List<Object> conj(Object xs, Object x) {
    var col = (Collection<Object>) xs;
    var result = new ArrayList<>(col);
    result.add(x);
    return result;
  }

  public static Object[] into_array(Object xs) {
    var col = (List<Object>) xs;
    var result = (Object[]) Array.newInstance(col.get(0).getClass(), col.size());
    return col.toArray(result);
  }

  public static Object[] into_array(Class cls, Object xs) {
    var col = (List<Object>) xs;
    var result = (Object[]) Array.newInstance(cls, col.size());
    return col.toArray(result);
  }

  public static String str(Object... args) {
    if (args.length == 1) {
      return args[0].toString();
    }
    StringBuilder sb = new StringBuilder();
    for (Object arg : args) {
      sb.append(arg);
    }
    return sb.toString();
  }

  /**
   * @noinspection unchecked
   */
  public static <T> T get(Object source, Object key) {
    if (source instanceof java.util.Map) {
      return (T) ((java.util.Map<?, ?>) source).get(key);
    }
    if (source instanceof java.util.List) {
      return (T) ((java.util.List<?>) source).get((Integer) key);
    }
    throw new RuntimeException("Unsupported source: " + source + ", key: " + key);
  }

  @SuppressWarnings("unchecked")
  private static <T extends Throwable> void throwException(
      Throwable exception,
      Object dummy) throws T {
    throw (T) exception;
  }

  public static <T> T throw_(Object exception) {
    throwException((Throwable) exception, null);
    return null;
  }

  public static <T> T try_(Callable<T> f) {
    try {
      return f.call();
    } catch (Exception e) {
      RT.throwException(e, null);
      return null;
    }
  }

  public static Object println(Object... xs) {
    for (Object x : xs) {
      System.out.print(x);
      System.out.print(" ");
    }
    System.out.println();
    return null;
  }

  public static Runnable runnable(Supplier<Object> f) {
    return f::get;
  }
}
