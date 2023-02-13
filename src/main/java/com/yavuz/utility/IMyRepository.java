package com.yavuz.utility;

/**
 * İlişkisel ya da ilişkisel olmayan tüm DB yapılarında
 * kullanılmak üzere genişletilebilir entegre edilebilir
 * bir sistem kullanmak için bu interface kullanılacaktır.
 * @param <T> Entity için type belirtir. (Musteri, Product, v.b.)
 * @param <ID> Entity içindeki @Id ile belirlenmiş id yi temsil eder.
 *            bu id nin type girilmelidir. (Long, String)
 */
public interface IMyRepository <T,ID>{
}
