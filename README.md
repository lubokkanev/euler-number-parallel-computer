# Euler's number parallel computation
This project computes the Euler's number ***e*** using multithreading.

## Formula
![alt text](http://i.imgur.com/mcbimw3.png "Formula")

## Usage
### Flags
* **-p \<number\>**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;number of iterations.
* **-t \<number\>**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;number of threads.
* **-q**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;quiet mode.
* **-o \<filename\>**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;output file.
   
### Defaults
* 2000 iterations.
* 2 threads.
* non-quiet mode - displays the gathered information of each thread. 
* the output is saved in the file output.txt in the working directory. 

## Statistics
* Speed-up S<sub>n</sub> = T<sub>1</sub> / T<sub>2</sub>
* Efficiency E<sub>n</sub> = S<sub>n</sub> / n

### Table
![alt text](http://i.imgur.com/mjIcU3u.png "Table")

### Graphs
![alt text](http://i.imgur.com/48KOgVy.png "Time T(n)")

![alt text](https://i.imgur.com/oPLEx4K.jpg "Speed-up S(n)")

![alt text](https://i.imgur.com/aBkAZi0.jpg "Efficiency E(n)")

# ***e***

2.71828 18284 59045 23536 02874 71352 66249 77572 47093 69995 95749 66967 62772 40766 30353 54759 45713 82178 52516 64274 27466 39193 20030 59921 81741 35966 29043 57290 03342 95260 59563 07381 32328 62794 34907 63233 82988 07531 95251 01901 15738 34187 93070 21540 89149 93488 41675 09244 76146 06680 82264 80016 84774 11853 74234 54424 37107 53907 77449 92069 55170 27618 38606 26133 13845 83000 75204 49338 26560 29760 67371 13200 70932 87091 27443 74704 72306 96977 20931 01416 92836 81902 55151 08657 46377 21112 52389 78442 50569 53696 77078 54499 69967 94686 44549 05987 93163 68892 30098 79312 77361 78215 42499 92295 76351 48220 82698 95193 66803 31825 28869 39849 64651 05820 93923 98294 88793 32036 25094 43117 30123 81970 68416 14039 70198 37679 32068 32823 76464 80429 53118 02328 78250 98194 55815 30175 67173 61332 06981 12509 96181 88159 30416 90351 59888 85193 45807 27386 67385 89422 87922 84998 92086 80582 57492 79610 48419 84443 63463 24496 84875 60233 62482 70419 78623 20900 21609 90235 30436 99418 49146 31409 34317 38143 64054 62531 52096 18369 08887 07016 76839 64243 78140 59271 45635 49061 30310 72085 10383 75051 01157 47704 17189 86106 87396 96552 12671 54688 95703 50354 02123 40784 98193 34321 06817 01210 05627 88023 51930 33224 74501 58539 04730 41995 77770 93503 66041 69973 29725 08868 76966 40355 57071 62268 44716 25607 98826 51787 13419 51246 65201 03059 21236 67719 43252 78675 39855 89448 96970 96409 75459 18569 56380 23637 01621 12047 74272 28364 89613 42251 64450 78182 44235 29486 36372 14174 02388 93441 24796 35743 70263 75529 44483 37998 01612 54922 78509 25778 25620 92622 64832 62779 33386 56648 16277 25164 01910 59004 91644 99828 93150 56604 72580 27786 31864 15519 56532 44258 69829 46959 30801 91529 87211 72556 34754 63964 47910 14590 40905 86298 49679 12874 06870 50489 58586 71747 98546 67757 57320 56812 88459 20541 33405 39220 00113 78630 09455 60688 16674 00169 84205 58040 33637 95376 45203 04024 32256 61352 78369 51177 88386 38744 39662 53224 98506 54995 88623 42818 99707 73327 61717 83928 03494 65014 34558 89707 19425 86398 77275 47109 62953 74152 11151 36835 06275 26023 26484 72870 39207 64310 05958 41166 12054 52970 30236 47254 92966 69381 15137 32275 36450 98889 03136 02057 24817 65851 18063 03644 28123 14965 50704 75102 54465 01172 72115 55194 86685 08003 68532 28183 15219 60037 35625 27944 95158 28418 82947 87610 85263 98139 55990 06737 64829 22443 75287 18462 45780 36192 98197 13991 47564 48826 26039 03381 44182 32625 15097 48279 87779 96437 30899 70388 86778 22713 83605 77297 88241 25611 90717 66394 65070 63304 52795 46618 55096 66618 56647 09711 34447 40160 70462 62156 80717 48187 78443 71436 98821 85596 70959 10259 68620 02353 71858 87485 69652 20005 03117 34392 07321 13908 03293 63447 97273 55955 27734 90717 83793 42163 70120 50054 51326 38354 40001 86323 99149 07054 79778 05669 78533 58048 96690 62951 19432 47309 95876 55236 81285 90413 83241 16072 26029 98330 53537 08761 38939 63917 79574 54016 13722 36187 89365 26053 81558 41587 18692 55386 06164 77983 40254 35128 43961 29460 35291 33259 42794 90433 72990 85731 58029 09586 31382 68329 14771 16396 33709 24003 16894 58636 06064 58459 25126 99465 57248 39186 56420 97526 85082 30754 42545 99376 91704 19777 80085 36273 09417 10163 43490 76964 23722 29435 23661 25572 50881 47792 23151 97477 80605 69672 53801 71807 76360 34624 59278 77846 58506 56050 78084 42115 29697 52189 08740 19660 90665 18035 16501 79250 46195 01366 58543 66327 12549 63990 85491 44200 01457 47608 19302 21206 60243 30096 41270 48943 90397 17719 51806 99086 99860 66365 83232 27870 93765 02260 14929 10115 17177 63594 46020 23249 30028 04018 67723 91028 80978 66605 65118 32600 43688 50881 71572 38669 84224 22010 24950 55188 16948 03221 00251 54264 94639 81287 36776 58927 68816 35983 12477 88652 01411 74110 91360 11649 95076 62907 79436 46005 85194 19985 60162 64790 76153 21038 72755 71269 92518 27568 79893 02761 76114 61625 49356 49590 37980 45838 18232 33686 12016 24373 65698 46703 78585 33052 75833 33793 99075 21660 69238 05336 98879 56513 72855 93883 49989 47074 16181 55012 53970 64648 17194 67083 48197 21448 88987 90676 50379 59036 69672 49499 25452 79033 72963 61626 58976 03949 85767 41397 35944 10237 44329 70935 54779 82629 61459 14429 36451 42861 71585 87339 74679 18975 71211 95618 73857 83644 75844 84235 55581 05002 56114 92391 51889 30994 63428 41393 60803 83091 66281 88115 03715 28496 70597 41625 62823 60921 68075 15017 77253 87402 56425 34708 79089 13729 17228 28611 51591 56837 25241 63077 22544 06337 87593 10598 26760 94420 32619 24285 31701 87817 72960 23541 30606 72136 04600 03896 61093 64709 51414 17185 77701 41806 06443 63681 54644 40053 31608 77831 43174 44081 19494 22975 59931 40118 88683 31483 28027 06553 83300 46932 90115 74414 75631 39997 22170 38046 17092 89457 90962 71662 26074 07187 49975 35921 27560 84414 73782 33032 70330 16823 71936 48002 17328 57349 35947 56433 41299 43024 85023 57322 14597 84328 26414 21684 87872 16733 67010 61509 42434 56984 40187 33128 10107 94512 72237 37886 12605 81656 68053 71439 61278 88732 52737 38903 92890 50686 53241 38062 79602 59303 87727 69778 37928 68409 32536 58807 33988 45721 87460 21005 31148 33513 23850 04782 71693 76218 00490 47955 97959 29059 16554 70505 77751 43081 75112 69898 51884 08718 56402 60353 05583 73783 24229 24185 62564 42550 22672 15598 02740 12617 97192 80471 39600 68916 38286 65277 00975 27670 69777 03643 92602 24372 84184 08832 51848 77047 26384 40379 53016 69054 65937 46161 93238 40363 89313 13643 27137 68884 10268 11219 89127 52230 56256 75625 47017 25086 34976 53672 88605 96675 27408 68627 40791 28565 76996 31378 97530 34660 61666 98042 18267 72456 05306 60773 89962 42183 40859 88207 18646 82623 21508 02882 86359 74683 96543 58856 68550 37731 31296 58797 58105 01214 91620 76567 69950 65971 53447 63470 32085 32156 03674 82860 83786 56803 07306 26576 33469 77429 56346 43716 70939 71930 60876 96349 53288 46833 61303 88294 31040 80029 68738 69117 06666 61468 00015 12114 34422 56023 87447 43252 50769 38707 77751 93299 94213 72772 11258 84360 87158 34835 62696 16619 80572 52661 22067 97540 62106 20806 49882 91845 43953 01529 98209 25030 05498 25704 33905 53570 16865 31205 26495 61485 72492 57386 20691 74036 95213 53373 25316 66345 46658 85972 86659 45113 64413 70331 39367 21185 69553 95210 84584 07244 32383 55860 63106 80696 49248 51232 63269 95146 03596 03729 72531 98368 42336 39046 32136 71011 61928 21711 15028 28016 04488 05880 23820 31981 49309 63695 96735 83274 20249 88245 68494 12738 60566 49135 25267 06046 23445 05492 27581 15170 93149 21879 59271 80019 40968 86698 68370 37302 20047 53143 38181 09270 80300 17205 93553 05207 00706 07223 39994 63990 57131 15870 99635 77735 90271 96285 06114 65148 37526 20956 53467 13290 02599 43976 63114 54590 26858 98979 11583 70934 19370 44115 51219 20117 16488 05669 45938 13118 38437 65620 62784 63104 90346 29395 00294 58341 16482 41149 69758 32601 18007 31699 43739 35069 66295 71241 02732 39138 74175 49230 71862 45454 32220 39552 73529 52402 45903 80574 45028 92246 88628 53365 42213 81572 21311 63288 11205 21464 89805 18009 20247 19391 71055 53901 13943 31668 15158 28843 68760 69611 02505 17100 73927 62385 55338 62725 53538 83096 06716 44662 37092 26468 09671 25406 18695 02143 17621 16681 40097 59528 14939 07222 60111 26811 53108 38731 76173 23235 26360 58381 73151 03459 57365 38223 53499 29358 22836 85100 78108 84634 34998 35184 04451 70427 01893 81994 24341 00905 75376 25776 75711 18090 08816 41833 19201 96262 34162 88166 52137 47173 25477 72778 34887 74366 51882 87521 56685 71950 63719 36565 39038 94493 66421 76400 31215 27870 22236 64636 35755 50356 55769 48886 54950 02708 53923 61710 55021 31147 41374 41061 34445 54419 21013 36172 99628 56948 99193 36918 47294 78580 72915 60885 10396 78195 94298 33186 48075 60836 79551 49663 64489 65592 94818 78517 84038 77332 62470 51945 05041 98477 42014 18394 77312 02815 88684 57072 90544 05751 06012 85258 05659 47030 46836 34459 26525 52137 00806 87520 09593 45360 73162 26118 72817 39280 74623 09468 53678 23106 09792 15993 60019 94623 79934 34210 68781 34973 46959 24646 97525 06246 95861 69091 78573 97659 51993 92993 99556 75427 14654 91045 68607 02099 01260 68187 04984 17807 91739 24071 94599 63230 60254 70790 17745 27513 18680 99822 84730 86076 65368 66855 51646 77029 11336 82756 31072 23346 72611 37054 90795 36583 45386 37196 23585 63126 18387 15677 41187 38527 72292 25947 43373 78569 55384 56246 80101 39057 27871 01651 29666 36764 45187 24656 53730 40244 36841 40814 48873 29578 47348 49000 30194 77888 02046 03246 60842 87535 18483 64959 19508 28883 23206 52212 81041 90448 04724 79492 91342 28495 19700 22601 31043 00624 10717 97150 27934 33263 40799 59605 31446 05323 04885 28972 91765 98760 16667 81193 79323 72453 85720 96075 82277 17848 33616 13582 61289 62261 18129 45592 74627 67137 79448 75867 53657 54486 14076 11931 12595 85126 55759 73457 30153 33642 63076 79854 43385 76171 53334 62325 27057 20053 03988 28949 90342 59566 23297 57824 88735 02925 91668 25894 45689 46559 92658 45476 26945 28780 51650 17206 74785 41788 79822 76806 53665 06419 10973 43452 88783 38621 72615 62695 82654 47820 56729 87756 42632 53215 94294 41803 99432 17000 09054 26507 63095 58846 58951 71709 14760 74371 36893 31946 90909 81904 50129 03070 99566 22662 03031 82649 36573 36984 19555 77696 37876 24918 85286 56866 07600 56602 56054 45711 33728 68402 05574 41603 08370 52312 24258 72234 38854 12317 94813 88550 07568 93811 24935 38631 86352 87083 79984 56926 19981 79452 33640 87429 59118 07474 53419 55142 03517 26184 20084 55091 70845 68236 82008 97739 45584 26792 14273 47756 08796 44279 20270 83121 50156 40634 13416 17166 44806 98154 83764 49157 39001 21217 04154 78725 91998 94382 53649 50514 77137 93991 47205 21952 90793 96137 62110 72384 94290 61635 76045 96231 25350 60685 37651 42311 53496 65683 71511 66042 20796 39446 66211 63255 15772 90709 78473 15627 82775 98788 13649 19512 57483 32879 37715 71459 09106 48416 42678 30994 97236 74420 17586 22694 02159 40792 44805 41255 36043 13179 92696 73915 75424 19296 60731 23937 63542 13923 06178 76753 95871 14361 04089 40996 60894 71418 34069 83629 93675 36262 15452 47298 46421 37528 91079 88438 13060 95552 62272 08375 18629 83706 67872 24430 19579 37937 86072 10725 42772 89071 73285 48743 74355 78196 65117 16618 33088 11291 20245 20404 86822 00072 34403 50254 48202 83425 41878 84653 60259 15064 45271 65770 00445 21097 73558 58976 22655 48494 16217 14989 53238 34216 00114 06295 07184 90427 78925 85527 43035 22139 68356 79018 07640 60421 38307 30877 44601 70842 68827 22611 77180 84266 43336 51780 00217 19034 49234 26426 62922 61456 00433 73838 68335 55534 34530 04264 81847 39892 15627 08609 56506 29340 40526 49432 44261 44566 59212 91225 64889 35696 55009 15430 64261 34252 66847 25949 14314 23939 88454 32486 32746 18428 46655 98533 23122 10466 25989 01417 12103 44608 42716 16619 00125 71958 70793 21756 96985 44013 39762 20967 49454 18540 71184 46433 94699 01626 98351 60784 89245 14058 94094 63952 67807 35457 97003 07051 16368 25194 87701 18976 40028 27648 41416 05872 06184 18529 71891 54019 68825 32893 09149 66534 57535 71427 31848 20163 84644 83249 90378 86069 00807 27093 27673 12758 19665 63941 14896 17168 32980 45513 97295 06687 60474 09154 20428 42999 35410 25829 11350 22416 90769 43166 85742 42522 50902 69390 34814 85645 13030 69925 19959 04363 84028 42926 74125 73422 44776 55841 77886 17173 72654 62085 49829 44989 46787 35092 95816 52632 07225 89923 68768 45701 78230 38096 56788 31122 89305 80914 05726 10865 88484 58731 01658 15116 75333 27674 88701 48291 67419 70151 25597 82572 70740 64318 08601 42814 90241 46780 47232 75976 84269 63393 57735 42930 18673 94397 16388 61176 42090 04068 66339 88568 41681 00387 23892 14483 17607 01166 84503 88721 23643 67043 31409 11557 33280 18297 79887 36590 91665 96124 02021 77855 88548 76176 16198 93707 94380 05666 33648 84365 08914 48055 71039 76521 46960 27662 58359 90519 87042 30017 94655 3679
