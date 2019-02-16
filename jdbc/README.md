# Spring JDBC

使用Spring JDBC提供一个转帐服务（保证事务），提供一个transferMoney接口：

transferMoney(Long srcUserId, Long targetUserId, double count)；// srcUserId及targetUserId为转帐用户标识

转帐涉及到的表（UserBalance）包含如下列：

userId：Long，代表用户标识；

balance：Doubcle，代表帐号余额。