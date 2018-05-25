function y=ograniczenia (G,x,m)
   

    switch m
        case 1
            g1 = G{1};
            y = g1(x);
        case 2
            g1 = G{1};
            g2 = G{2};
            y = g1(x) && g2(x);
        case 3
            g1 = G{1};
            g2 = G{2};
            g3 = G{3};
            y = g1(x) && g2(x) && g3(x);
        case 4
            g1 = G{1};
            g2 = G{2};
            g3 = G{3};
            g4 = G{4};
            y = g1(x) && g2(x) && g3(x) && g4(x);
        case 5
            g1 = G{1};
            g2 = G{2};
            g3 = G{3};
            g4 = G{4};
            g5 = G{5};
            y = g1(x) && g2(x) && g3(x) && g4(x) && g5(x);
        case 6
            g1 = G{1};
            g2 = G{2};
            g3 = G{3};
            g4 = G{4};
            g5 = G{5};
            g6 = G{6};
            y = g1(x) && g2(x) && g3(x) && g4(x) && g5(x) && g6(x);
    end

end