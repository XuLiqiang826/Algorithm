function binary = collapse(chrom)%%对种群实施一次测量,得到二进制编码 %输入chrom:为迸子比特编码 %输出binary:二进制编码 %得到种群大小和编码长度[M,N] = size(chrom) ;%种群大小M = M/2;%二进制编码大小初始化binary= zeros(M,N); for i = 1 :M	for j = 1 :N		%产生[0,1]区间的随机数 		pick = rand;		%随机数大于a的平方		if pick > (chrom(2.*i-1,j)^2)			binary(i,j) = 1;        else			binary(i,j) = 0;		end	endend