function [trans,matrix] = LDA_multi(data,label,dimension,figure_i)    

    % x һ����һ������,label һ����һ�������ı�ǩ
    [n,m] = size(label);
    
    if(dimension > min(n-1,size(data,2)))
        error('���棺LDA dimension ��������ʵ������')
    end

    % ��ȡÿ���������ĵ����������
    feature = {};
    center = {};

    global_center = sum(data,2)/m;
    for i = 1:size(label,1)
        % ���� i
        label_fit = zeros(n,m);
        label_fit(i,:) = 1;
        feature{i} = data(:,sum(label_fit == label,1) == 3);
        center{i} = sum(feature{i},2)/size(feature{i},2);
    end

    % ����
    Sb = 0;
    for i = 1:size(label,1)
    %     center{i}-global_center
        distance = (center{i}-global_center)*(center{i}-global_center)'; %4x1 1x4 
        Sb = Sb + size(feature{i},2) * distance;
    end
    % ����Sb��rankֻ��С��class����-1
    fprintf('Sb rank is %d\n', rank(Sb));
    

    % ȫ��ɢ�Ⱦ���
    St = 0;
    for j = 1:size(data,2)
        St = St + (data(:,j)-global_center) * ...
            (data(:,j)-global_center)';                           %4x1 1x4
    end

    
    % ���ڼ��
    Sw = 0;
    for i = 1:size(label,1)
        distance = 0;
    %     center{i}-global_center
        for j = 1:size(feature{i},2)
            distance = distance + (feature{i}(:,j)-center{i}) * ...
                (feature{i}(:,j)-center{i})';                           %4x1 1x4
        end
        Sw = Sw+distance;
    end
%     Sw

%     St
%     Sb+Sw
    fprintf('����ͨ������St��Sb��Ȼ����Sw���򻯴���\n')                % Sb+Sw == St

    [V,D] = eig(Sw^-1*Sb,'vector') % D-����ֵ����  V-������������
    fprintf('Sw^-1*Sb  rank is %d\n', rank(Sw^-1*Sb));
    fprintf('����ֵ���� %d����������ֵ������Ϊ %d \n', length(D),n-1);

    % get trans Matrix
    transform = [];
    for j = 1:dimension
        Max = -10000;index = 0;
        for i = 1:length(D)
            if(Max<D(i))
                Max = D(i);index=i;
            end
        end
        D(index)=-10000;
    %     Max
    %     index
        transform = [transform V(:,index)];
    end

    % plot 
    figure(figure_i)
    c = ['y','r','g','b'];
    for i = 1:size(label,1)
        x_trans = transform'*feature{i};
        plot(x_trans(1,:),x_trans(2,:),[c(mod(i,4)+1) '*'])
        hold on;
    end
    
    figure(figure_i+1)
    for i = 1:size(label,1)
        plot(feature{i}(1,:),feature{i}(2,:),[c(mod(i,4)+1) '*'])
        hold on;
    end
    
    matrix = transform';
    trans = matrix*data;

end