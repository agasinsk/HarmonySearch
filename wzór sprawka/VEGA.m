
function wynik = VEGA(n, m, Lp, L, pc, pm, f1, f2, G, limit)

clc;
figure(1);
hold on;
F1niezd = zeros(0);
F2niezd = zeros(0);
X_star = zeros(0,n);

N =  n;     %liczba zmiennych
Lp = Lp;  %liczba powtorzen
m  = m;     %liczba ograniczen
L = L;    %liczba osobników w populacji
p_c = pc; %p-stwo crossowania
p_m = pm; %p-stwo mutacji

ograniczenia_x = limit;

q = floor(L/2);
X = zeros (2*q, N);
F1 = zeros(1, 2*q);
F2 = zeros(1, 2*q);
Fstar_1 = zeros(1, 2*q);
Fstar_2 = zeros(1, 2*q);


%losowanie
i=1;
while i<2*q
    temp = zeros(N,1);
    for j=1:1:N
        temp(j) = (ograniczenia_x(j,2) - ograniczenia_x(j,1)) * rand(1,1) + ograniczenia_x(j,1);
    end;
    if (ograniczenia(G, temp, m ))
        X(i,:) = temp;
        i=i+1;
    end;
end;

for  h = 1:1:Lp
%obliczenie F celu
for i=1:1:2*q
F1(i) = f1(X(i,:));
F2(i) = f2(X(i,:));
end;

%podzia³ na 2 podpopulacji
p = randperm(2*q); 
p_1 = p(1:q);
p_2 = p(q+1:2*q);

Fit1 = zeros(q, 2); 
Fit2 = zeros(q, 2);

subpopulacja1 = zeros(q, N);  %tworzenie macierzy rodziców dla 1 populacji
subpopulacja2 = zeros(q, N);


for i=1:1:q
    Fit1(i,:) = [ F1(p_1(i)) p_1(i) ];
    Fit2(i,:) = [ F2(p_2(i)) p_2(i) ];
end;

 Fit1 = sortrows(Fit1, 1);
 Fit2 = sortrows(Fit2, 1);


%%%%%%  SELEKCJA  %%%%%%%
z = linspace(1,1,q);

for i=1:1:q
   subpopulacja1(i,:) = X(Fit1(z(i),2),:);
   subpopulacja2(i,:) = X(Fit2(z(i),2),:);
end;

% % %%%%% CROSSOWANIE %%%%
child1 = zeros(q, N);  %macierz crossownia
child2 = zeros(q, N);

p = randperm(q);
z1 = zeros(1,q);
z2 = zeros(1,q);


for i=1:1:q-1
    z1(i) = p(p(i));
    z2(i) = p(i+1);
end;

z1(q) = p(2);
z2(q) = p(q);
do_ilu = floor(q*p_c);
for i=1:1:do_ilu
    child1(i,:) = (subpopulacja1(z1(i),:) + subpopulacja1(z2(i),:))/2;
    child2(i,:) = (subpopulacja2(z1(i),:) + subpopulacja2(z2(i),:))/2;
end;

for i=do_ilu+1:1:q
    child1(i,:) = (subpopulacja1(z1(i),:) + subpopulacja1(z2(i),:))/2;
    child2(i,:) = (subpopulacja2(z1(i),:) + subpopulacja2(z2(i),:))/2;
end;



% %%%% MUTACJA %%%%
z = ceil(q * p_m);
p1 = randperm(q);
p2 = randperm(q);
p1 = p1(1:z);
p2 = p2(1:z);


for i=1:1:N
    zakres_mutacji(i) = 0.01 * (ograniczenia_x(i,2) - ograniczenia_x(i,1));
end;

for j = 1:1:N
    for i=1:1:z
        child1(p2(i),j) = child1(p2(i),j) + 2 * zakres_mutacji(j) * rand(1,1) - zakres_mutacji(j);
        if (child1(p2(i),j) > ograniczenia_x(j,2))
            child1(p2(i),j) = child1(p2(i),j) - zakres_mutacji(j);
        end;
        if (child1(p2(i),j) < ograniczenia_x(j,1))
             child1(p2(i),j) = child1(p2(i),j) + zakres_mutacji(j);
        end;
        child2(p1(i),j) = child2(p1(i),j) + 2 * zakres_mutacji(j) * rand(1,1) - zakres_mutacji(j);
        if (child2(p1(i),j) > ograniczenia_x(j,2))
            child2(p1(i),j) = child2(p1(i),j) - zakres_mutacji(j);
        end;
        if (child2(p1(i),j) < ograniczenia_x(j,1))
             child2(p1(i),j) = child2(p1(i),j) + zakres_mutacji(j);
        end;
    end;
end;

%%sprawdzenie zakresu

for i=1:1:N
    X(:,i) = [child1(:,i)  ;  child2(:,i)]';
end;

for i = 1:1:2*q
    while ~(ograniczenia(G,X(i,:),m))
           X(i,:) = X(randi(2*q),:);
    end;
    
end; 

for i=1:1:2*q
Fstar_1(i) = f1(X(i,:));
Fstar_2(i) = f2(X(i,:));
end;
plot(Fstar_1, Fstar_2, '.');

for i=1:length(Fstar_1)
    niezdom = true;
    for j=1:length(Fstar_2)
        if i~=j
            if (Fstar_1(j)<Fstar_1(i)) && (Fstar_2(j)<Fstar_2(i))
                niezdom = false;
            end
        end
    end
    if niezdom == true
        F1niezd = [F1niezd Fstar_1(i)]; 
        F2niezd = [F2niezd Fstar_2(i)];
        X_star = [ X_star; X(i,:)];      
    end
end

end;
F1niezd1=zeros(0);
F2niezd2=zeros(0);
X_star1 = zeros(0,n);
for i=1:length(F1niezd)
    niezdom = true;
    for j=1:length(F2niezd)
        if i~=j
            if (F1niezd(j)<F1niezd(i)) && (F2niezd(j)<F2niezd(i))
                niezdom = false;
            end
        end
    end
    if niezdom == true
        F1niezd1 = [F1niezd1 F1niezd(i)]; 
        F2niezd2 = [F2niezd2 F2niezd(i)];
        X_star1 = [ X_star1; X_star(i,:) ]; 
        
    end
end
figure(2)
wynik = [ F1niezd1' F2niezd2' X_star1];
plot(F1niezd1, F2niezd2,'.');
end
