-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2021 at 01:07 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `onlineexam`
--

DELIMITER $$
--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `RandString` (`length` INT(3)) RETURNS VARCHAR(100) CHARSET utf8mb4 NO SQL
    DETERMINISTIC
begin
    SET @returnStr = '';
    SET @allowedChars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    SET @i = 0;

    WHILE (@i < length) DO
        SET @returnStr = CONCAT(@returnStr, substring(@allowedChars, FLOOR(RAND() * LENGTH(@allowedChars) + 1), 1));
        SET @i = @i + 1;
    END WHILE;

    RETURN @returnStr;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `cid` tinyint(3) NOT NULL,
  `cname` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`cid`, `cname`) VALUES
(1, 'BCA-FIRST'),
(2, 'BCA-SECOND'),
(3, 'BCA-THIRD'),
(4, 'BCOM-FIRST'),
(5, 'BCOM-SECOND');

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `eid` int(11) NOT NULL,
  `cname` varchar(30) NOT NULL,
  `sname` varchar(30) NOT NULL,
  `totalq` int(11) NOT NULL,
  `dur` int(11) NOT NULL,
  `max` int(11) NOT NULL,
  `pass` int(11) NOT NULL,
  `date` date NOT NULL,
  `quetype` varchar(10) NOT NULL,
  `state` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`eid`, `cname`, `sname`, `totalq`, `dur`, `max`, `pass`, `date`, `quetype`, `state`) VALUES
(1, 'BCA-FIRST', 'Opera', 5, 2, 50, 20, '2021-03-22', 'Random', 'Cleared'),
(2, 'BCA-FIRST', 'Opera', 5, 2, 100, 40, '2021-03-24', 'Choose', 'Cleared'),
(3, 'BCA-FIRST', 'Opera', 5, 2, 100, 40, '2021-03-24', 'Choose', 'Cleared'),
(5, 'BCA-FIRST', 'Opera', 3, 2, 100, 40, '2021-03-24', 'Choose', 'Cleared'),
(6, 'BCA-FIRST', 'Opera', 4, 2, 100, 40, '2021-03-25', 'Choose', 'Cleared'),
(12, 'BCA-FIRST', 'Opera', 3, 1, 100, 40, '2021-03-25', 'Random', 'Cleared'),
(15, 'BCA-FIRST', 'Opera', 2, 20, 20, 15, '2021-03-24', 'Random', 'Cleared'),
(17, 'BCA-FIRST', 'Opera', 2, 2, 40, 20, '2021-03-24', 'Random', 'Cleared'),
(18, 'BCA-FIRST', 'Opera', 2, 2, 40, 20, '2021-03-24', 'Choose', 'Cleared'),
(19, 'BCA-FIRST', 'Opera', 6, 2, 100, 40, '2021-03-29', 'Random', 'Attempted'),
(20, 'BCA-FIRST', 'Opera', 5, 20, 40, 10, '2021-04-21', 'Random', 'Attempted'),
(21, 'BCA-FIRST', 'Opera', 5, 10, 10, 4, '2021-04-26', 'Choose', 'Attempted'),
(22, 'BCA-FIRST', 'Opera', 5, 10, 10, 2, '2021-05-01', 'Random', 'ACTIVATE'),
(23, 'BCA-FIRST', 'Opera', 5, 10, 10, 4, '2021-04-23', 'Random', 'Attempted'),
(24, 'BCA-FIRST', 'Opera', 5, 10, 10, 4, '2021-04-12', 'Random', 'Attempted'),
(25, 'BCA-FIRST', 'Opera', 5, 10, 10, 2, '2021-05-03', 'Random', 'ACTIVATE'),
(26, 'BCA-FIRST', 'Opera', 5, 10, 10, 6, '2021-04-13', 'Choose', 'Attempted'),
(27, 'BCA-SECOND', 'Data Structure', 4, 10, 20, 10, '2021-04-13', 'Random', 'Activate'),
(28, 'BCA-SECOND', 'Data Structure', 4, 10, 20, 10, '2021-04-12', 'Choose', 'Attempted'),
(29, 'BCA-SECOND', 'Data Structure', 4, 10, 20, 10, '2021-04-14', 'Random', 'Attempted');

-- --------------------------------------------------------

--
-- Table structure for table `examquestion`
--

CREATE TABLE `examquestion` (
  `eid` int(11) NOT NULL,
  `qno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `examquestion`
--

INSERT INTO `examquestion` (`eid`, `qno`) VALUES
(1, 3),
(1, 7),
(1, 4),
(1, 2),
(2, 1),
(2, 4),
(3, 2),
(3, 4),
(4, 2),
(4, 4),
(4, 5),
(5, 1),
(5, 2),
(6, 1),
(6, 4),
(7, 1),
(7, 4),
(8, 2),
(8, 7),
(9, 1),
(9, 2),
(9, 3),
(10, 1),
(10, 4),
(11, 3),
(11, 4),
(11, 6),
(12, 2),
(12, 4),
(12, 7),
(13, 6),
(13, 4),
(13, 3),
(13, 1),
(14, 6),
(14, 1),
(14, 2),
(14, 7),
(14, 5),
(15, 5),
(15, 3),
(16, 3),
(16, 4),
(16, 2),
(16, 5),
(16, 7),
(16, 6),
(17, 7),
(17, 5),
(18, 1),
(18, 2),
(19, 3),
(19, 4),
(19, 2),
(19, 7),
(19, 5),
(19, 1),
(20, 1),
(20, 6),
(20, 30),
(20, 3),
(20, 29),
(21, 6),
(21, 30),
(22, 3),
(22, 1),
(22, 29),
(22, 6),
(22, 30),
(23, 3),
(23, 30),
(23, 6),
(23, 29),
(23, 1),
(24, 3),
(24, 1),
(24, 29),
(24, 6),
(24, 30),
(25, 30),
(25, 1),
(25, 29),
(25, 6),
(25, 3),
(26, 1),
(26, 2),
(26, 3),
(26, 6),
(26, 29),
(26, 30),
(26, 31),
(26, 32),
(27, 33),
(27, 34),
(27, 36),
(27, 35),
(28, 33),
(28, 34),
(28, 35),
(28, 36),
(29, 33),
(29, 36),
(29, 34),
(29, 35),
(21, 3),
(21, 31),
(21, 2);

-- --------------------------------------------------------

--
-- Table structure for table `finalresult`
--

CREATE TABLE `finalresult` (
  `sid` int(11) NOT NULL,
  `cname` varchar(15) NOT NULL,
  `totalq` int(11) NOT NULL,
  `attques` int(11) NOT NULL,
  `nattques` int(11) NOT NULL,
  `corans` int(11) NOT NULL,
  `wrgans` int(11) NOT NULL,
  `totalm` int(11) NOT NULL,
  `maxm` int(11) NOT NULL,
  `per` float NOT NULL,
  `result` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `finalresult`
--

INSERT INTO `finalresult` (`sid`, `cname`, `totalq`, `attques`, `nattques`, `corans`, `wrgans`, `totalm`, `maxm`, `per`, `result`) VALUES
(3, 'BCA-SECOND', 16, 16, 0, 8, 8, 40, 80, 50, 'Passed'),
(9, 'BCA-SECOND', 20, 20, 0, 15, 5, 75, 100, 75, 'Passed');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `user` varchar(25) NOT NULL,
  `pass` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `paper`
--

CREATE TABLE `paper` (
  `cid` varchar(25) NOT NULL,
  `sid` varchar(25) NOT NULL,
  `totalq` int(11) NOT NULL,
  `dur` int(11) NOT NULL,
  `maxmarks` int(11) NOT NULL,
  `passing` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paper`
--

INSERT INTO `paper` (`cid`, `sid`, `totalq`, `dur`, `maxmarks`, `passing`, `date`) VALUES
('BCA-FIRST', 'C Language', 20, 2, 100, 40, '2021-03-27'),
('BCA-FIRST', 'Computer Organization', 20, 2, 100, 40, '2021-03-24'),
('BCA-FIRST', 'Mohan', 20, 2, 100, 40, '2021-03-24'),
('BCA-FIRST', 'Opera', 22, 2, 100, 40, '2021-03-01');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `sid` varchar(25) NOT NULL,
  `qno` int(11) NOT NULL,
  `ques` varchar(200) NOT NULL,
  `op1` varchar(50) NOT NULL,
  `op2` varchar(50) NOT NULL,
  `op3` varchar(50) NOT NULL,
  `op4` varchar(50) NOT NULL,
  `ans` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`sid`, `qno`, `ques`, `op1`, `op2`, `op3`, `op4`, `ans`) VALUES
('Opera', 1, 'What is GOP', 'njnjnjk', 'bhbhbhb', 'jbhbhib', 'bhbvgvghvhg', 'B'),
('Opera', 2, 'What is CPP', 'programming', 'machine', 'code', 'Query', 'D'),
('Opera', 3, 'What is TMT', 'bhskjcbj', 'bnbn,b,', 'bn,,mnln', 'b,nbn,b,nb', 'B'),
('Opera', 6, 'What is Good', 'jhjvjhb', 'bhb,b.,', 'bnbnb ', 'bnb n, .m', 'B'),
('C Language', 26, 'What is C', 'LANGUAGE', 'TERM', 'SYMTOMS', 'VIRUS', 'B'),
('Opera', 29, 'what is css', 'stylesheet', 'javascript', 'script', 'language', 'C'),
('Opera', 30, 'What is Java', 'machine', 'language', 'subject', 'book', 'B'),
('Opera', 31, 'What us YGhjgdf', 'nfjnfd', 'snna', 'nmk,,m.', 'bbhjbhjb', 'B'),
('Opera', 32, 'kjsghfdhgkjsfhg', 'nfjnfd,lkskg;l', 'snnanmn,', 'nmk,,m.', 'bbhjbhjb', 'C'),
('Data Structure', 33, 'What is LinkedLIst ?', 'linear data structure', 'unlinear data structure', 'index value', 'super value', 'A'),
('Data Structure', 34, 'What is array', 'single value', 'different type multiple values', 'multiple values', 'same type multiple values', 'D'),
('Data Structure', 35, 'jhfjkhgkmgkm', 'jkjskjg', 'mmsnknmglk', 'mgklnsklgm', 'mmnklmkl', 'B'),
('Data Structure', 36, 'kjabfjioghab', 'mkmlkmkl;kk', 'kmgklmnglkm', 'k;lk;lk;lk,', ' mklmlkmlkml', 'B');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `ID` int(3) NOT NULL,
  `First_Name` varchar(25) NOT NULL,
  `Last_Name` varchar(25) NOT NULL,
  `Course` int(10) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Session` varchar(10) NOT NULL,
  `Image` varchar(100) NOT NULL,
  `user` varchar(25) NOT NULL,
  `pass` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`ID`, `First_Name`, `Last_Name`, `Course`, `Phone`, `Address`, `Session`, `Image`, `user`, `pass`) VALUES
(1, 'Ramesh', 'Kumar', 1, '9889787783', 'Gandhi Nagar', '2020-21', 'C:\\Users\\prati\\OneDrive\\Documents\\practice\\bear.jpg', 'Abc', 'Abc'),
(2, 'Pankaj', 'Shah', 3, '7897897893', 'Dhobi Ghat Chandmari', '2020-21', '', 'bcd', 'bcd'),
(3, 'Omesh', 'Singh', 2, '8748717055', 'Housing Board', '2019-20', '', 'omesh13', 'omesh'),
(4, 'Umesh', 'Rathore', 2, '9238778989', 'hajhkjhklgjl', '2019-20', '', 'umesh', 'umesh'),
(5, 'hghgfa', 'hjahjkhgk', 1, '7676287658', 'vghjkkjh', '2019-20', 'C:\\Users\\prati\\OneDrive\\Documents\\20181108_130650.jpg', 'KGAU4R43', 'UMBFY'),
(6, 'Ram ', 'Singh', 1, '7775829895', 'Ganga Jaliya', '2019-20', 'C:\\Users\\prati\\OneDrive\\Documents\\Pictures\\polymorphism.PNG', 'VHFHUFFK', 'AH7BO'),
(7, 'Umesh', 'Kumar', 2, '8785728789', 'Umid Nagar', '2019-20', 'C:\\Users\\prati\\OneDrive\\Documents\\Pictures\\multilevel inheritence.PNG', 'PKGC0QCA', '4FIY0'),
(8, 'Yash', 'Bhati', 2, '7728785252', 'jhjafkhghljfh', '2021-22', 'C:\\Users\\prati\\OneDrive\\Documents\\Pictures\\polymorphism.PNG', 'AETK708R', 'WYRPX'),
(9, 'Pratik', 'Chanchlani', 2, '8987867677', 'Talheti', '2021-22', 'C:\\Users\\prati\\OneDrive\\Documents\\20181108_130650.jpg', 'pratik123', 'pratik123');

-- --------------------------------------------------------

--
-- Table structure for table `studentexam`
--

CREATE TABLE `studentexam` (
  `eid` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `qno` int(11) NOT NULL,
  `ans` varchar(30) NOT NULL,
  `expans` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studentexam`
--

INSERT INTO `studentexam` (`eid`, `sid`, `qno`, `ans`, `expans`) VALUES
(29, 9, 33, 'A', 'A'),
(29, 9, 36, 'B', 'C'),
(29, 9, 34, 'D', 'D'),
(29, 9, 35, 'B', 'B'),
(29, 9, 33, 'A', 'A'),
(29, 9, 36, 'B', 'C'),
(29, 9, 34, 'D', 'D'),
(29, 9, 35, 'B', 'B'),
(29, 9, 33, 'A', 'A'),
(29, 9, 36, 'B', 'C'),
(29, 9, 34, 'D', 'D'),
(29, 9, 35, 'B', 'B'),
(29, 3, 33, 'A', 'A'),
(29, 3, 36, 'B', 'C'),
(29, 3, 34, 'D', 'D'),
(29, 3, 35, 'B', 'C'),
(29, 3, 33, 'A', 'A'),
(29, 3, 36, 'B', 'C'),
(29, 3, 34, 'D', 'B'),
(29, 3, 35, 'B', 'C'),
(20, 1, 1, 'B', 'A'),
(20, 1, 6, 'B', 'B'),
(20, 1, 30, 'B', 'B'),
(20, 1, 3, 'B', 'B'),
(20, 1, 29, 'C', 'A'),
(21, 1, 6, 'B', 'C'),
(21, 1, 30, 'B', ''),
(21, 1, 3, 'B', 'C'),
(21, 1, 31, 'B', ''),
(21, 1, 2, 'D', 'C');

-- --------------------------------------------------------

--
-- Table structure for table `studentresult`
--

CREATE TABLE `studentresult` (
  `sid` int(11) NOT NULL,
  `eid` int(11) NOT NULL,
  `stu_name` varchar(25) NOT NULL,
  `cname` varchar(20) NOT NULL,
  `sname` varchar(20) NOT NULL,
  `totalq` int(11) NOT NULL,
  `attques` int(11) NOT NULL,
  `correct` int(11) NOT NULL,
  `obtmarks` int(11) NOT NULL,
  `result` varchar(10) NOT NULL,
  `res_state` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studentresult`
--

INSERT INTO `studentresult` (`sid`, `eid`, `stu_name`, `cname`, `sname`, `totalq`, `attques`, `correct`, `obtmarks`, `result`, `res_state`) VALUES
(3, 29, 'Omesh Singh', 'BCA-SECOND', 'Data Structure', 4, 4, 2, 10, 'Pass', 'Declared'),
(3, 29, 'Omesh Singh', 'BCA-SECOND', 'Data Structure', 4, 4, 2, 10, 'Pass', 'Declared'),
(9, 29, 'Pratik Chanchlani', 'BCA-SECOND', 'Data Structure', 4, 4, 3, 15, 'Pass', 'Declared'),
(9, 29, 'Pratik Chanchlani', 'BCA-SECOND', 'Data Structure', 4, 4, 3, 15, 'Pass', 'Declared'),
(9, 29, 'Pratik Chanchlani', 'BCA-SECOND', 'Data Structure', 4, 4, 3, 15, 'Pass', 'Declared'),
(3, 29, 'Omesh Singh', 'BCA-SECOND', 'Data Structure', 4, 4, 2, 10, 'Pass', 'Declared'),
(3, 29, 'Omesh Singh', 'BCA-SECOND', 'Data Structure', 4, 4, 2, 10, 'Pass', 'Declared'),
(1, 21, 'Ramesh Kumar', 'BCA-FIRST', 'Opera', 5, 5, 3, 24, 'Pass', 'Declared'),
(1, 21, 'Ramesh Kumar', 'BCA-FIRST', 'Opera', 5, 5, 3, 24, 'Pass', 'Declared'),
(1, 21, 'Ramesh Kumar', 'BCA-FIRST', 'Opera', 5, 5, 3, 24, 'Pass', 'Declared'),
(9, 29, 'Pratik Chanchlani', 'BCA-SECOND', 'Data Structure', 4, 4, 3, 15, 'Pass', 'Declared'),
(9, 29, 'Pratik Chanchlani', 'BCA-SECOND', 'Data Structure', 4, 4, 3, 15, 'Pass', 'Declared');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `cid` varchar(25) NOT NULL,
  `sid` tinyint(3) NOT NULL,
  `sname` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`cid`, `sid`, `sname`) VALUES
('BCA-FIRST', 7, 'Opera'),
('BCA-FIRST', 8, 'Mohan'),
('BCA-FIRST', 9, 'Computer Organization'),
('BCA-FIRST', 10, 'C Language'),
('BCA-SECOND', 11, 'Data Structure'),
('BCA-SECOND', 12, 'DBMS');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`eid`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`user`);

--
-- Indexes for table `paper`
--
ALTER TABLE `paper`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`qno`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`sid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
