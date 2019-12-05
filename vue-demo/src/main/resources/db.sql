/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.59 : Database - vue_demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vue_demo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vue_demo`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`age`) values ('123459789','root','e10adc3949ba59abbe56e057f20f883e',13),('7890586278831955968','LYY','e10adc3949ba59abbe56e057f20f883e',12),('7890587922244149248','TTTG2222','e10adc3949ba59abbe56e057f20f883e',16),('7890607148399960064','QQQ','e10adc3949ba59abbe56e057f20f883e',12),('7890607504781582336','WE','e10adc3949ba59abbe56e057f20f883e',12),('7890607565301194752','rew','4e0b54fd7e71d264160d531937d02b0e',12);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
