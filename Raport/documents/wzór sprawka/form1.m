
function varargout = form1(varargin)

gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @form1_OpeningFcn, ...
                   'gui_OutputFcn',  @form1_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...   
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end

function form1_OpeningFcn(hObject, eventdata, handles, varargin)

handles.output = hObject;

%%% na start
set(handles.edit1,'string','4*x(1)^2+4*x(2)^2');
set(handles.edit2,'string','(x(1)-5)^2 + (x(2)-5)^2');
set(handles.edit3,'string','(x(1)-5)^2+x(2)^2<=25');
set(handles.edit4,'string','(x(1)-8)^2+(x(2)+3)^2>=7.7');
set(handles.edit31,'string','1000');
set(handles.edit32,'string','10');
set(handles.edit33,'string','0.3');
set(handles.edit34,'string','0.3');
set(handles.edit9,'string','0');
set(handles.edit10,'string','3');
set(handles.edit11,'string','0');
set(handles.edit12,'string','5');
set(handles.uitable2,'data',cell(0,0));
set(handles.uitable2,'ColumnName',{'f1(x)';'f2(x)'; 'x1'});

% Update handles structure
guidata(hObject, handles);
;




function varargout = form1_OutputFcn(hObject, eventdata, handles) 

varargout{1} = handles.output;


% --- Executes on button press in pushbutton1.
function pushbutton1_Callback(hObject, eventdata, handles)
pole1 = get(handles.edit1, 'String');
newChr = strrep(pole1,'^','.^');
zmiana = strcat('@(x) ', char(newChr));
f1 = str2func(zmiana);

pole2 = get(handles.edit2, 'String');
newChr = strrep(pole2,'^','.^');
zmiana = strcat('@(x) ', char(newChr));
f2 = str2func(zmiana);

contents = get(handles.popupmenu3,'String'); 
i_l_ograniczen = str2num(contents{get(handles.popupmenu3,'Value')});

switch i_l_ograniczen
    case 1
        pole1 = get(handles.edit3, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g1 = str2func(zmiana);
        G = {g1};
    case 2
        pole1 = get(handles.edit3, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g1 = str2func(zmiana);
        
        pole1 = get(handles.edit4, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g2 = str2func(zmiana);
                
        G = {g1, g2};
    case 3
        pole1 = get(handles.edit3, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g1 = str2func(zmiana);
        
        pole1 = get(handles.edit4, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g2 = str2func(zmiana);
        
        pole1 = get(handles.edit5, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g3 = str2func(zmiana);
                
        G = {g1, g2, g3};
    case 4
         pole1 = get(handles.edit3, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g1 = str2func(zmiana);
        
        pole1 = get(handles.edit4, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g2 = str2func(zmiana);
        
        pole1 = get(handles.edit5, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g3 = str2func(zmiana);
        
        pole1 = get(handles.edit6, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g4 = str2func(zmiana);
                
        G = {g1, g2, g3, g4};
    case 5
        pole1 = get(handles.edit3, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g1 = str2func(zmiana);
        
        pole1 = get(handles.edit4, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g2 = str2func(zmiana);
        
        pole1 = get(handles.edit5, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g3 = str2func(zmiana);
        
        pole1 = get(handles.edit6, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g4 = str2func(zmiana);
        
        pole1 = get(handles.edit7, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g5 = str2func(zmiana);
                
        G = {g1, g2, g3, g4, g5};
    case 6
        pole1 = get(handles.edit3, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g1 = str2func(zmiana);
        
        pole1 = get(handles.edit4, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g2 = str2func(zmiana);
        
        pole1 = get(handles.edit5, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g3 = str2func(zmiana);
        
        pole1 = get(handles.edit6, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g4 = str2func(zmiana);
        
        pole1 = get(handles.edit7, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g5 = str2func(zmiana);
        
        pole1 = get(handles.edit8, 'String');
        newChr = strrep(pole1,'^','.^');
        zmiana = strcat('@(x) ', char(newChr));
        g6 = str2func(zmiana);
                
        G = {g1, g2, g3, g4, g5, g6};
end;

contents = get(handles.popupmenu1,'String'); 
i_l_zmiennych = str2num(contents{get(handles.popupmenu1,'Value')});

switch i_l_zmiennych
    case 1
        limits = zeros(i_l_zmiennych,2);
        x1a = str2num(get(handles.edit9, 'String'));
        x1b = str2num(get(handles.edit10, 'String'));
        limits = [x1a x1b];
        
    case 2
        limits = zeros(i_l_zmiennych,2);
        x1a = str2num(get(handles.edit9, 'String'));
        x1b = str2num(get(handles.edit10, 'String'));
        x2a = str2num(get(handles.edit11, 'String'));
        x2b = str2num(get(handles.edit12, 'String'));
        limits = [x1a x1b; x2a x2b];
        
    case 3
        limits = zeros(i_l_zmiennych,2);
        x1a = str2num(get(handles.edit9,  'String'));
        x1b = str2num(get(handles.edit10, 'String'));
        x2a = str2num(get(handles.edit11, 'String'));
        x2b = str2num(get(handles.edit12, 'String'));
        x3a = str2num(get(handles.edit13, 'String'));
        x3b = str2num(get(handles.edit14, 'String'));
        limits = [x1a x1b; x2a x2b; x3a x3b];
        
    case 4
        limits = zeros(i_l_zmiennych,2);
        x1a = str2num(get(handles.edit9, 'String'));
        x1b = str2num(get(handles.edit10, 'String'));
        x2a = str2num(get(handles.edit11, 'String'));
        x2b = str2num(get(handles.edit12, 'String'));
        x3a = str2num(get(handles.edit13, 'String'));
        x3b = str2num(get(handles.edit14, 'String'));
        x4a = str2num(get(handles.edit17, 'String'));
        x4b = str2num(get(handles.edit18, 'String'));
        limits = [x1a x1b; x2a x2b; x3a x3b; x4a x4b];
        
    case 5
        limits = zeros(i_l_zmiennych,2);
        x1a = str2num(get(handles.edit9, 'String'));
        x1b = str2num(get(handles.edit10, 'String'));
        x2a = str2num(get(handles.edit11, 'String'));
        x2b = str2num(get(handles.edit12, 'String'));
        x3a = str2num(get(handles.edit13, 'String'));
        x3b = str2num(get(handles.edit14, 'String'));
        x4a = str2num(get(handles.edit17, 'String'));
        x4b = str2num(get(handles.edit18, 'String'));
        x5a = str2num(get(handles.edit17, 'String'));
        x5b = str2num(get(handles.edit18, 'String'));
        limits = [x1a x1b; x2a x2b; x3a x3b; x4a x4b; x5a x5b];

    case 6
        limits = zeros(i_l_zmiennych,2);
        x1a = str2num(get(handles.edit9, 'String'));
        x1b = str2num(get(handles.edit10, 'String'));
        x2a = str2num(get(handles.edit11, 'String'));
        x2b = str2num(get(handles.edit12, 'String'));
        x3a = str2num(get(handles.edit13, 'String'));
        x3b = str2num(get(handles.edit14, 'String'));
        x4a = str2num(get(handles.edit17, 'String'));
        x4b = str2num(get(handles.edit18, 'String'));
        x5a = str2num(get(handles.edit19, 'String'));
        x5b = str2num(get(handles.edit20, 'String'));
        x6a = str2num(get(handles.edit21, 'String'));
        x6b = str2num(get(handles.edit22, 'String'));
        limits = [x1a x1b; x2a x2b; x3a x3b; x4a x4b; x5a x5b; x6a x6b];
        
     case 7
        limits = zeros(i_l_zmiennych,2);
        x1a = str2num(get(handles.edit9, 'String'));
        x1b = str2num(get(handles.edit10, 'String'));
        x2a = str2num(get(handles.edit11, 'String'));
        x2b = str2num(get(handles.edit12, 'String'));
        x3a = str2num(get(handles.edit13, 'String'));
        x3b = str2num(get(handles.edit14, 'String'));
        x4a = str2num(get(handles.edit17, 'String'));
        x4b = str2num(get(handles.edit18, 'String'));
        x5a = str2num(get(handles.edit19, 'String'));
        x5b = str2num(get(handles.edit20, 'String'));
        x6a = str2num(get(handles.edit21, 'String'));
        x6b = str2num(get(handles.edit22, 'String'));
        x7a = str2num(get(handles.edit23, 'String'));
        x7b = str2num(get(handles.edit24, 'String'));
        limits = [x1a x1b; x2a x2b; x3a x3b; x4a x4b; x5a x5b; x6a x6b; x7a x7b];
        
    case 8
        limits = zeros(i_l_zmiennych,2);
        x1a = str2num(get(handles.edit9, 'String'));
        x1b = str2num(get(handles.edit10, 'String'));
        x2a = str2num(get(handles.edit11, 'String'));
        x2b = str2num(get(handles.edit12, 'String'));
        x3a = str2num(get(handles.edit13, 'String'));
        x3b = str2num(get(handles.edit14, 'String'));
        x4a = str2num(get(handles.edit17, 'String'));
        x4b = str2num(get(handles.edit18, 'String'));
        x5a = str2num(get(handles.edit19, 'String'));
        x5b = str2num(get(handles.edit20, 'String'));
        x6a = str2num(get(handles.edit21, 'String'));
        x6b = str2num(get(handles.edit22, 'String'));
        x7a = str2num(get(handles.edit23, 'String'));
        x7b = str2num(get(handles.edit24, 'String'));
        x8a = str2num(get(handles.edit25, 'String'));
        x8b = str2num(get(handles.edit26, 'String'));
        limits = [x1a x1b; x2a x2b; x3a x3b; x4a x4b; x5a x5b; x6a x6b; x7a x7b; x8a x8b];
        
        
    case 9
        limits = zeros(i_l_zmiennych,2);
        x1a = str2num(get(handles.edit9, 'String'));
        x1b = str2num(get(handles.edit10, 'String'));
        x2a = str2num(get(handles.edit11, 'String'));
        x2b = str2num(get(handles.edit12, 'String'));
        x3a = str2num(get(handles.edit13, 'String'));
        x3b = str2num(get(handles.edit14, 'String'));
        x4a = str2num(get(handles.edit17, 'String'));
        x4b = str2num(get(handles.edit18, 'String'));
        x5a = str2num(get(handles.edit19, 'String'));
        x5b = str2num(get(handles.edit20, 'String'));
        x6a = str2num(get(handles.edit21, 'String'));
        x6b = str2num(get(handles.edit22, 'String'));
        x7a = str2num(get(handles.edit23, 'String'));
        x7b = str2num(get(handles.edit24, 'String'));
        x8a = str2num(get(handles.edit25, 'String'));
        x8b = str2num(get(handles.edit26, 'String'));
        x9a = str2num(get(handles.edit27, 'String'));
        x9b = str2num(get(handles.edit28, 'String'));
        limits = [x1a x1b; x2a x2b; x3a x3b; x4a x4b; x5a x5b; x6a x6b; x7a x7b; x8a x8b; x9a x9b];
        
        case 10
        limits = zeros(i_l_zmiennych,2);
        x1a = str2num(get(handles.edit9, 'String'));
        x1b = str2num(get(handles.edit10, 'String'));
        x2a = str2num(get(handles.edit11, 'String'));
        x2b = str2num(get(handles.edit12, 'String'));
        x3a = str2num(get(handles.edit13, 'String'));
        x3b = str2num(get(handles.edit14, 'String'));
        x4a = str2num(get(handles.edit17, 'String'));
        x4b = str2num(get(handles.edit18, 'String'));
        x5a = str2num(get(handles.edit19, 'String'));
        x5b = str2num(get(handles.edit20, 'String'));
        x6a = str2num(get(handles.edit21, 'String'));
        x6b = str2num(get(handles.edit22, 'String'));
        x7a = str2num(get(handles.edit23, 'String'));
        x7b = str2num(get(handles.edit24, 'String'));
        x8a = str2num(get(handles.edit25, 'String'));
        x8b = str2num(get(handles.edit26, 'String'));
        x9a = str2num(get(handles.edit27, 'String'));
        x9b = str2num(get(handles.edit28, 'String'));
        x10a = str2num(get(handles.edit29, 'String'));
        x10b = str2num(get(handles.edit30, 'String'));
        limits = [x1a x1b; x2a x2b; x3a x3b; x4a x4b; x5a x5b; x6a x6b; x7a x7b; x8a x8b; x9a x9b; x10a x10b];
        
end;

figure(1)
title('Rozwi¹zania');
xlabel('f1');
ylabel('f=f2(f1)');
figure(2)

iteracje = str2double(get(handles.edit31, 'String'));
populacja = str2double(get(handles.edit32, 'String'));
cross = str2double(get(handles.edit33, 'String'));
mutacja= str2double(get(handles.edit34, 'String'));
wynik = VEGA(i_l_zmiennych,i_l_ograniczen,iteracje,populacja,cross,mutacja,f1,f2,G, limits);
title('Front Paretto');
xlabel('f1');
ylabel('f=f2(f1)');
set(handles.uitable2,'data',wynik);



function edit1_Callback(hObject, eventdata, handles)


function edit1_CreateFcn(hObject, eventdata, handles)

if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit2_Callback(hObject, eventdata, handles)



% --- Executes during object creation, after setting all properties.
function edit2_CreateFcn(hObject, eventdata, handles)

if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on selection change in popupmenu1.
function popupmenu1_Callback(hObject, eventdata, handles)
str = get(hObject, 'String');
val = get(hObject,'Value');
% Set current data to the selected data set.
switch str{val};
case '1' 
   handles.n = 1;
   set(handles.text19,'visible','off');
   set(handles.text20,'visible','off');
   set(handles.text21,'visible','off');
   set(handles.text22,'visible','off');
   set(handles.text23,'visible','off');
   set(handles.text24,'visible','off');
   set(handles.text25,'visible','off');
   set(handles.text26,'visible','off');
   set(handles.text27,'visible','off');
   set(handles.edit9,'visible','on');
   set(handles.edit10,'visible','on');
   set(handles.edit11,'visible','off');
   set(handles.edit12,'visible','off');
   set(handles.edit13,'visible','off');
   set(handles.edit14,'visible','off');
   set(handles.edit17,'visible','off');
   set(handles.edit18,'visible','off');
   set(handles.edit19,'visible','off');
   set(handles.edit20,'visible','off');
   set(handles.edit21,'visible','off');
   set(handles.edit22,'visible','off');
   set(handles.edit23,'visible','off');
   set(handles.edit24,'visible','off');
   set(handles.edit25,'visible','off');
   set(handles.edit26,'visible','off');
   set(handles.edit27,'visible','off');
   set(handles.edit28,'visible','off');
   set(handles.edit29,'visible','off');
   set(handles.edit30,'visible','off');
   set(handles.uitable2,'ColumnName',{'f1(x)';'f2(x)'; 'x1'});
case '2'
   handles.n = 2;
   set(handles.text19,'visible','on');
   set(handles.text20,'visible','off');
   set(handles.text21,'visible','off');
   set(handles.text22,'visible','off');
   set(handles.text23,'visible','off');
   set(handles.text24,'visible','off');
   set(handles.text25,'visible','off');
   set(handles.text26,'visible','off');
   set(handles.text27,'visible','off');
   set(handles.edit9,'visible','on');
   set(handles.edit10,'visible','on');
   set(handles.edit11,'visible','on');
   set(handles.edit12,'visible','on');
   set(handles.edit13,'visible','off');
   set(handles.edit14,'visible','off');
   set(handles.edit17,'visible','off');
   set(handles.edit18,'visible','off');
   set(handles.edit19,'visible','off');
   set(handles.edit20,'visible','off');
   set(handles.edit21,'visible','off');
   set(handles.edit22,'visible','off');
   set(handles.edit23,'visible','off');
   set(handles.edit24,'visible','off');
   set(handles.edit25,'visible','off');
   set(handles.edit26,'visible','off');
   set(handles.edit27,'visible','off');
   set(handles.edit28,'visible','off');
   set(handles.edit29,'visible','off');
   set(handles.edit30,'visible','off');
   set(handles.uitable2,'ColumnName',{'f1(x)';'f2(x)'; 'x1'; 'x2'});
case '3' 
    handles.n = 3;
    set(handles.text19,'visible','on');
   set(handles.text20,'visible','on');
   set(handles.text21,'visible','off');
   set(handles.text22,'visible','off');
   set(handles.text23,'visible','off');
   set(handles.text24,'visible','off');
   set(handles.text25,'visible','off');
   set(handles.text26,'visible','off');
   set(handles.text27,'visible','off');
   set(handles.edit9,'visible','on');
   set(handles.edit10,'visible','on');
   set(handles.edit11,'visible','on');
   set(handles.edit12,'visible','on');
   set(handles.edit13,'visible','on');
   set(handles.edit14,'visible','on');
   set(handles.edit17,'visible','off');
   set(handles.edit18,'visible','off');
   set(handles.edit19,'visible','off');
   set(handles.edit20,'visible','off');
   set(handles.edit21,'visible','off');
   set(handles.edit22,'visible','off');
   set(handles.edit23,'visible','off');
   set(handles.edit24,'visible','off');
   set(handles.edit25,'visible','off');
   set(handles.edit26,'visible','off');
   set(handles.edit27,'visible','off');
   set(handles.edit28,'visible','off');
   set(handles.edit29,'visible','off');
   set(handles.edit30,'visible','off');
   set(handles.uitable2,'ColumnName',{'f1(x)';'f2(x)'; 'x1'; 'x2'; 'x3'});
case '4'
   handles.n = 4;
   set(handles.text19,'visible','on');
   set(handles.text20,'visible','on');
   set(handles.text21,'visible','on');
   set(handles.text22,'visible','off');
   set(handles.text23,'visible','off');
   set(handles.text24,'visible','off');
   set(handles.text25,'visible','off');
   set(handles.text26,'visible','off');
   set(handles.text27,'visible','off');
   set(handles.edit9,'visible','on');
   set(handles.edit10,'visible','on');
   set(handles.edit11,'visible','on');
   set(handles.edit12,'visible','on');
   set(handles.edit13,'visible','on');
   set(handles.edit14,'visible','on');
   set(handles.edit17,'visible','on');
   set(handles.edit18,'visible','on');
   set(handles.edit19,'visible','off');
   set(handles.edit20,'visible','off');
   set(handles.edit21,'visible','off');
   set(handles.edit22,'visible','off');
   set(handles.edit23,'visible','off');
   set(handles.edit24,'visible','off');
   set(handles.edit25,'visible','off');
   set(handles.edit26,'visible','off');
   set(handles.edit27,'visible','off');
   set(handles.edit28,'visible','off');
   set(handles.edit29,'visible','off');
   set(handles.edit30,'visible','off');
   set(handles.uitable2,'ColumnName',{'f1(x)';'f2(x)'; 'x1'; 'x2'; 'x3'; 'x4'});
case '5' 
   handles.n = 5;
   set(handles.text19,'visible','on');
   set(handles.text20,'visible','on');
   set(handles.text21,'visible','on');
   set(handles.text22,'visible','on');
   set(handles.text23,'visible','off');
   set(handles.text24,'visible','off');
   set(handles.text25,'visible','off');
   set(handles.text26,'visible','off');
   set(handles.text27,'visible','off');
   set(handles.edit9,'visible','on');
   set(handles.edit10,'visible','on');
   set(handles.edit11,'visible','on');
   set(handles.edit12,'visible','on');
   set(handles.edit13,'visible','on');
   set(handles.edit14,'visible','on');
   set(handles.edit17,'visible','on');
   set(handles.edit18,'visible','on');
   set(handles.edit19,'visible','on');
   set(handles.edit20,'visible','on');
   set(handles.edit21,'visible','off');
   set(handles.edit22,'visible','off');
   set(handles.edit23,'visible','off');
   set(handles.edit24,'visible','off');
   set(handles.edit25,'visible','off');
   set(handles.edit26,'visible','off');
   set(handles.edit27,'visible','off');
   set(handles.edit28,'visible','off');
   set(handles.edit29,'visible','off');
   set(handles.edit30,'visible','off');
   set(handles.uitable2,'ColumnName',{'f1(x)';'f2(x)'; 'x1'; 'x2'; 'x3'; 'x4';'x5'});
case '6' 
   handles.n = 6;
   set(handles.text19,'visible','on');
   set(handles.text20,'visible','on');
   set(handles.text21,'visible','on');
   set(handles.text22,'visible','on');
   set(handles.text23,'visible','on');
   set(handles.text24,'visible','off');
   set(handles.text25,'visible','off');
   set(handles.text26,'visible','off');
   set(handles.text27,'visible','off');
   set(handles.edit9,'visible','on');
   set(handles.edit10,'visible','on');
   set(handles.edit11,'visible','on');
   set(handles.edit12,'visible','on');
   set(handles.edit13,'visible','on');
   set(handles.edit14,'visible','on');
   set(handles.edit17,'visible','on');
   set(handles.edit18,'visible','on');
   set(handles.edit19,'visible','on');
   set(handles.edit20,'visible','on');
   set(handles.edit21,'visible','on');
   set(handles.edit22,'visible','on');
   set(handles.edit23,'visible','off');
   set(handles.edit24,'visible','off');
   set(handles.edit25,'visible','off');
   set(handles.edit26,'visible','off');
   set(handles.edit27,'visible','off');
   set(handles.edit28,'visible','off');
   set(handles.edit29,'visible','off');
   set(handles.edit30,'visible','off');
   set(handles.uitable2,'ColumnName',{'f1(x)';'f2(x)'; 'x1'; 'x2'; 'x3'; 'x4';'x5';'x6'});
case '7'
   handles.n = 7;
   set(handles.text19,'visible','on');
   set(handles.text20,'visible','on');
   set(handles.text21,'visible','on');
   set(handles.text22,'visible','on');
   set(handles.text23,'visible','on');
   set(handles.text24,'visible','on');
   set(handles.text25,'visible','off');
   set(handles.text26,'visible','off');
   set(handles.text27,'visible','off');
   set(handles.edit9,'visible','on');
   set(handles.edit10,'visible','on');
   set(handles.edit11,'visible','on');
   set(handles.edit12,'visible','on');
   set(handles.edit13,'visible','on');
   set(handles.edit14,'visible','on');
   set(handles.edit17,'visible','on');
   set(handles.edit18,'visible','on');
   set(handles.edit19,'visible','on');
   set(handles.edit20,'visible','on');
   set(handles.edit21,'visible','on');
   set(handles.edit22,'visible','on');
   set(handles.edit23,'visible','on');
   set(handles.edit24,'visible','on');
   set(handles.edit25,'visible','off');
   set(handles.edit26,'visible','off');
   set(handles.edit27,'visible','off');
   set(handles.edit28,'visible','off');
   set(handles.edit29,'visible','off');
   set(handles.edit30,'visible','off');
   set(handles.uitable2,'ColumnName',{'f1(x)';'f2(x)'; 'x1'; 'x2'; 'x3'; 'x4';'x5';'x6';'x7'});
case '8' 
   handles.n = 8;
   set(handles.text19,'visible','on');
   set(handles.text20,'visible','on');
   set(handles.text21,'visible','on');
   set(handles.text22,'visible','on');
   set(handles.text23,'visible','on');
   set(handles.text24,'visible','on');
   set(handles.text25,'visible','on');
   set(handles.text26,'visible','off');
   set(handles.text27,'visible','off');
   set(handles.edit9,'visible','on');
   set(handles.edit10,'visible','on');
   set(handles.edit11,'visible','on');
   set(handles.edit12,'visible','on');
   set(handles.edit13,'visible','on');
   set(handles.edit14,'visible','on');
   set(handles.edit17,'visible','on');
   set(handles.edit18,'visible','on');
   set(handles.edit19,'visible','on');
   set(handles.edit20,'visible','on');
   set(handles.edit21,'visible','on');
   set(handles.edit22,'visible','on');
   set(handles.edit23,'visible','on');
   set(handles.edit24,'visible','on');
   set(handles.edit25,'visible','on');
   set(handles.edit26,'visible','on');
   set(handles.edit27,'visible','off');
   set(handles.edit28,'visible','off');
   set(handles.edit29,'visible','off');
   set(handles.edit30,'visible','off');
   set(handles.uitable2,'ColumnName',{'f1(x)';'f2(x)'; 'x1'; 'x2'; 'x3'; 'x4';'x5';'x6';'x7';'x8'});
case '9'
   handles.n = 9;
   set(handles.text19,'visible','on');
   set(handles.text20,'visible','on');
   set(handles.text21,'visible','on');
   set(handles.text22,'visible','on');
   set(handles.text23,'visible','on');
   set(handles.text24,'visible','on');
   set(handles.text25,'visible','on');
   set(handles.text26,'visible','on');
   set(handles.text27,'visible','off');
   set(handles.edit9,'visible','on');
   set(handles.edit10,'visible','on');
   set(handles.edit11,'visible','on');
   set(handles.edit12,'visible','on');
   set(handles.edit13,'visible','on');
   set(handles.edit14,'visible','on');
   set(handles.edit17,'visible','on');
   set(handles.edit18,'visible','on');
   set(handles.edit19,'visible','on');
   set(handles.edit20,'visible','on');
   set(handles.edit21,'visible','on');
   set(handles.edit22,'visible','on');
   set(handles.edit23,'visible','on');
   set(handles.edit24,'visible','on');
   set(handles.edit25,'visible','on');
   set(handles.edit26,'visible','on');
   set(handles.edit27,'visible','on');
   set(handles.edit28,'visible','on');
   set(handles.edit29,'visible','off');
   set(handles.edit30,'visible','off');
   set(handles.uitable2,'ColumnName',{'f1(x)';'f2(x)'; 'x1'; 'x2'; 'x3'; 'x4';'x5';'x6';'x7';'x8';'x9'});
case '10'
   handles.n = 10;
   set(handles.text19,'visible','on');
   set(handles.text20,'visible','on');
   set(handles.text21,'visible','on');
   set(handles.text22,'visible','on');
   set(handles.text23,'visible','on');
   set(handles.text24,'visible','on');
   set(handles.text25,'visible','on');
   set(handles.text26,'visible','on');
   set(handles.text27,'visible','on');
   set(handles.edit9,'visible','on');
   set(handles.edit10,'visible','on');
   set(handles.edit11,'visible','on');
   set(handles.edit12,'visible','on');
   set(handles.edit13,'visible','on');
   set(handles.edit14,'visible','on');
   set(handles.edit17,'visible','on');
   set(handles.edit18,'visible','on');
   set(handles.edit19,'visible','on');
   set(handles.edit20,'visible','on');
   set(handles.edit21,'visible','on');
   set(handles.edit22,'visible','on');
   set(handles.edit23,'visible','on');
   set(handles.edit24,'visible','on');
   set(handles.edit25,'visible','on');
   set(handles.edit26,'visible','on');
   set(handles.edit27,'visible','on');
   set(handles.edit28,'visible','on');
   set(handles.edit29,'visible','on');
   set(handles.edit30,'visible','on');
   set(handles.uitable2,'ColumnName',{'f1(x)';'f2(x)'; 'x1'; 'x2'; 'x3'; 'x4';'x5';'x6';'x7';'x8';'x9';'x10'});
end;
guidata(hObject,handles);


% --- Executes during object creation, after setting all properties.
function popupmenu1_CreateFcn(hObject, ~, handles)
% hObject    handle to popupmenu1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: popupmenu controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on selection change in popupmenu2.
function popupmenu2_Callback(hObject, eventdata, handles)
% hObject    handle to popupmenu2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: contents = cellstr(get(hObject,'String')) returns popupmenu2 contents as cell array
%        contents{get(hObject,'Value')} returns selected item from popupmenu2


% --- Executes during object creation, after setting all properties.
function popupmenu2_CreateFcn(hObject, eventdata, handles)
% hObject    handle to popupmenu2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: popupmenu controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on selection change in popupmenu3.
function popupmenu3_Callback(hObject, eventdata, handles)


% Determine the selected data set.
str = get(hObject, 'String');
val = get(hObject,'Value');
% Set current data to the selected data set.
switch str{val};
case '1' 
   handles.m = 1;
   set(handles.edit8,'visible','off');
   set(handles.edit7,'visible','off');
   set(handles.edit6,'visible','off');
   set(handles.edit5,'visible','off');
   set(handles.edit4,'visible','off');
   set(handles.edit3,'visible','on');
   set(handles.text14,'visible','off');
   set(handles.text13,'visible','off');
   set(handles.text12,'visible','off');
   set(handles.text11,'visible','off');
   set(handles.text10,'visible','off');
   
case '2'
   handles.m = 2;
   set(handles.edit8,'visible','off');
   set(handles.edit7,'visible','off');
   set(handles.edit6,'visible','off');
   set(handles.edit5,'visible','off');
   set(handles.edit4,'visible','on');
   set(handles.edit3,'visible','on');
   set(handles.text14,'visible','off');
   set(handles.text13,'visible','off');
   set(handles.text12,'visible','off');
   set(handles.text11,'visible','off');
   set(handles.text10,'visible','on');
case '3' 
    handles.m = 3;
    set(handles.edit8,'visible','off');
   set(handles.edit7,'visible','off');
   set(handles.edit6,'visible','off');
   set(handles.edit5,'visible','on');
   set(handles.edit4,'visible','on');
   set(handles.edit3,'visible','on');
   set(handles.text14,'visible','off');
   set(handles.text13,'visible','off');
   set(handles.text12,'visible','off');
   set(handles.text11,'visible','on');
   set(handles.text10,'visible','on');
case '4'
   handles.m = 4;
   set(handles.edit8,'visible','off');
   set(handles.edit7,'visible','off');
   set(handles.edit6,'visible','on');
   set(handles.edit5,'visible','on');
   set(handles.edit4,'visible','on');
   set(handles.edit3,'visible','on');
   set(handles.text14,'visible','off');
   set(handles.text13,'visible','off');
   set(handles.text12,'visible','on');
   set(handles.text11,'visible','on');
   set(handles.text10,'visible','on');
case '6' 
   handles.m = 6;
   set(handles.edit8,'visible','on');
   set(handles.edit7,'visible','on');
   set(handles.edit6,'visible','on');
   set(handles.edit5,'visible','on');
   set(handles.edit4,'visible','on');
   set(handles.edit3,'visible','on');
   set(handles.text14,'visible','on');
   set(handles.text13,'visible','on');
   set(handles.text12,'visible','on');
   set(handles.text11,'visible','on');
   set(handles.text10,'visible','on');
case '5' 
   handles.m = 5;
   set(handles.edit8,'visible','off');
   set(handles.edit7,'visible','on');
   set(handles.edit6,'visible','on');
   set(handles.edit5,'visible','on');
   set(handles.edit4,'visible','on');
   set(handles.edit3,'visible','on');
   set(handles.text14,'visible','off');
   set(handles.text13,'visible','on');
   set(handles.text12,'visible','on');
   set(handles.text11,'visible','on');
   set(handles.text10,'visible','on');

end;
% Save the handles structure.
guidata(hObject,handles)

   
% --- Executes during object creation, after setting all properties.
function popupmenu3_CreateFcn(hObject, eventdata, handles)
% hObject    handle to popupmenu3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: popupmenu controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit3_Callback(hObject, eventdata, handles)
% hObject    handle to edit3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit3 as text
%        str2double(get(hObject,'String')) returns contents of edit3 as a double


% --- Executes during object creation, after setting all properties.
function edit3_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit4_Callback(hObject, eventdata, handles)
% hObject    handle to edit4 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit4 as text
%        str2double(get(hObject,'String')) returns contents of edit4 as a double


% --- Executes during object creation, after setting all properties.
function edit4_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit4 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit5_Callback(hObject, eventdata, handles)
% hObject    handle to edit5 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit5 as text
%        str2double(get(hObject,'String')) returns contents of edit5 as a double


% --- Executes during object creation, after setting all properties.
function edit5_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit5 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit6_Callback(hObject, eventdata, handles)
% hObject    handle to edit6 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit6 as text
%        str2double(get(hObject,'String')) returns contents of edit6 as a double


% --- Executes during object creation, after setting all properties.
function edit6_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit6 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit7_Callback(hObject, eventdata, handles)
% hObject    handle to edit7 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit7 as text
%        str2double(get(hObject,'String')) returns contents of edit7 as a double


% --- Executes during object creation, after setting all properties.
function edit7_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit7 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit8_Callback(hObject, eventdata, handles)
% hObject    handle to edit8 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit8 as text
%        str2double(get(hObject,'String')) returns contents of edit8 as a double


% --- Executes during object creation, after setting all properties.
function edit8_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit8 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit9_Callback(hObject, eventdata, handles)
% hObject    handle to edit9 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit9 as text
%        str2double(get(hObject,'String')) returns contents of edit9 as a double


% --- Executes during object creation, after setting all properties.
function edit9_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit9 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit10_Callback(hObject, eventdata, handles)
% hObject    handle to edit10 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit10 as text
%        str2double(get(hObject,'String')) returns contents of edit10 as a double


% --- Executes during object creation, after setting all properties.
function edit10_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit10 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit11_Callback(hObject, eventdata, handles)
% hObject    handle to edit11 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit11 as text
%        str2double(get(hObject,'String')) returns contents of edit11 as a double


% --- Executes during object creation, after setting all properties.
function edit11_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit11 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit12_Callback(hObject, eventdata, handles)
% hObject    handle to edit12 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit12 as text
%        str2double(get(hObject,'String')) returns contents of edit12 as a double


% --- Executes during object creation, after setting all properties.
function edit12_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit12 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit13_Callback(hObject, eventdata, handles)
% hObject    handle to edit13 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit13 as text
%        str2double(get(hObject,'String')) returns contents of edit13 as a double


% --- Executes during object creation, after setting all properties.
function edit13_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit13 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit14_Callback(hObject, eventdata, handles)
% hObject    handle to edit14 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit14 as text
%        str2double(get(hObject,'String')) returns contents of edit14 as a double


% --- Executes during object creation, after setting all properties.
function edit14_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit14 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit17_Callback(hObject, eventdata, handles)
% hObject    handle to edit17 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit17 as text
%        str2double(get(hObject,'String')) returns contents of edit17 as a double


% --- Executes during object creation, after setting all properties.
function edit17_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit17 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit18_Callback(hObject, eventdata, handles)
% hObject    handle to edit18 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit18 as text
%        str2double(get(hObject,'String')) returns contents of edit18 as a double


% --- Executes during object creation, after setting all properties.
function edit18_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit18 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit19_Callback(hObject, eventdata, handles)
% hObject    handle to edit19 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit19 as text
%        str2double(get(hObject,'String')) returns contents of edit19 as a double


% --- Executes during object creation, after setting all properties.
function edit19_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit19 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit20_Callback(hObject, eventdata, handles)
% hObject    handle to edit20 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit20 as text
%        str2double(get(hObject,'String')) returns contents of edit20 as a double


% --- Executes during object creation, after setting all properties.
function edit20_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit20 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit21_Callback(hObject, eventdata, handles)
% hObject    handle to edit21 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit21 as text
%        str2double(get(hObject,'String')) returns contents of edit21 as a double


% --- Executes during object creation, after setting all properties.
function edit21_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit21 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit22_Callback(hObject, eventdata, handles)
% hObject    handle to edit22 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit22 as text
%        str2double(get(hObject,'String')) returns contents of edit22 as a double


% --- Executes during object creation, after setting all properties.
function edit22_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit22 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit23_Callback(hObject, eventdata, handles)
% hObject    handle to edit23 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit23 as text
%        str2double(get(hObject,'String')) returns contents of edit23 as a double


% --- Executes during object creation, after setting all properties.
function edit23_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit23 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit24_Callback(hObject, eventdata, handles)
% hObject    handle to edit24 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit24 as text
%        str2double(get(hObject,'String')) returns contents of edit24 as a double


% --- Executes during object creation, after setting all properties.
function edit24_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit24 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit25_Callback(hObject, eventdata, handles)
% hObject    handle to edit25 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit25 as text
%        str2double(get(hObject,'String')) returns contents of edit25 as a double


% --- Executes during object creation, after setting all properties.
function edit25_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit25 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit26_Callback(hObject, eventdata, handles)
% hObject    handle to edit26 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit26 as text
%        str2double(get(hObject,'String')) returns contents of edit26 as a double


% --- Executes during object creation, after setting all properties.
function edit26_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit26 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit27_Callback(hObject, eventdata, handles)
% hObject    handle to edit27 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit27 as text
%        str2double(get(hObject,'String')) returns contents of edit27 as a double


% --- Executes during object creation, after setting all properties.
function edit27_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit27 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit28_Callback(hObject, eventdata, handles)
% hObject    handle to edit28 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit28 as text
%        str2double(get(hObject,'String')) returns contents of edit28 as a double


% --- Executes during object creation, after setting all properties.
function edit28_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit28 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit29_Callback(hObject, eventdata, handles)
% hObject    handle to edit29 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit29 as text
%        str2double(get(hObject,'String')) returns contents of edit29 as a double

function edit30_Callback(hObject, eventdata, handles)

% --- Executes during object creation, after setting all properties.
function edit29_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit29 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end




% --- Executes during object creation, after setting all properties.
function edit30_CreateFcn(hObject, eventdata, handles)

if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit31_Callback(hObject, eventdata, handles)
% hObject    handle to edit31 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit31 as text
%        str2double(get(hObject,'String')) returns contents of edit31 as a double


% --- Executes during object creation, after setting all properties.
function edit31_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit31 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit32_Callback(hObject, eventdata, handles)
% hObject    handle to edit32 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit32 as text
%        str2double(get(hObject,'String')) returns contents of edit32 as a double


% --- Executes during object creation, after setting all properties.
function edit32_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit32 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit33_Callback(hObject, eventdata, handles)
% hObject    handle to edit33 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit33 as text
%        str2double(get(hObject,'String')) returns contents of edit33 as a double


% --- Executes during object creation, after setting all properties.
function edit33_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit33 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit34_Callback(hObject, eventdata, handles)
% hObject    handle to edit34 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit34 as text
%        str2double(get(hObject,'String')) returns contents of edit34 as a double


% --- Executes during object creation, after setting all properties.
function edit34_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit34 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end
